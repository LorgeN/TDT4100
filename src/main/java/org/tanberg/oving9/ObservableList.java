package org.tanberg.oving9;

import com.google.common.collect.Lists;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.function.UnaryOperator;

public class ObservableList<T> implements List<T> {

    private final List<T> backingList;
    private final int sizeLimit;
    private final Collection<ListChangeListener<T>> listeners;

    public ObservableList() {
        this(-1);
    }

    public ObservableList(int sizeLimit) {
        // Slight optimization; Initialize list with capacity if given maz size
        this(sizeLimit == -1 ? new ArrayList<>() : new ArrayList<>(sizeLimit), sizeLimit);
    }

    public ObservableList(List<T> backingList, int sizeLimit) {
        this.backingList = backingList;
        this.sizeLimit = sizeLimit;
        this.listeners = Lists.newArrayList();
    }

    // This is stupid
    protected void addElement(int index, T value) {
        this.add(index, value);
    }

    protected void addElement(T value) {
        // Type. Parameters. Please.
        if (!this.acceptsElement(value)) {
            throw new IllegalArgumentException();
        }

        this.add(value);
    }

    protected void removeElement(int index) {
        this.remove(index);
    }

    // Like honestly, type params guys dafuq
    public boolean acceptsElement(Object object) {
        if (object == null) {
            return false;
        }

        Class<T> type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return type.isAssignableFrom(object.getClass());
    }

    public T getElement(int index) {
        return this.get(index);
    }

    public int getSizeLimit() {
        return this.sizeLimit;
    }

    public void subscribe(ListChangeListener<T> listener) {
        if (this.listeners.contains(listener)) {
            return;
        }

        this.listeners.add(listener);
    }

    public void unsubscribe(ListChangeListener<T> listener) {
        this.listeners.remove(listener);
    }

    public boolean isFull() {
        return this.sizeLimit != -1 && this.size() >= this.sizeLimit;
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.backingList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.backingList.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.backingList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.backingList.toArray(a);
    }

    @Override
    public boolean add(T t) {
        this.ensureSpace();
        if (!this.backingList.add(t)) {
            return false;
        }

        this.notifyChange(t, true);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!this.backingList.remove(o)) {
            return false;
        }

        this.notifyChange((T) o, false);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.backingList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        // This will be slower than using #addAll of the backing list but it will probably take me more time to write
        // this impl than it will ever save
        boolean val = false;
        for (T value : collection) {
            val |= this.add(value);
        }

        return val;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Honestly I am way too lazy");
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean val = false;
        for (Object o : collection) {
            val |= this.remove(o);
        }

        return val;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Honestly I am way too lazy");
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException("Honestly I am way too lazy");
    }

    @Override
    public void sort(Comparator<? super T> c) {
        this.backingList.sort(c);
    }

    @Override
    public void clear() {
        for (T val : this) {
            this.notifyChange(val, true);
        }

        this.backingList.clear();
    }

    @Override
    public boolean equals(Object o) {
        return this.backingList.equals(o);
    }

    @Override
    public int hashCode() {
        return this.backingList.hashCode();
    }

    @Override
    public T get(int index) {
        return this.backingList.get(index);
    }

    @Override
    public T set(int index, T element) {
        T set = this.backingList.set(index, element);
        this.notifyChange(element, true);
        return set;
    }

    @Override
    public void add(int index, T element) {
        this.backingList.add(index, element);
        this.notifyChange(element, true);
    }

    @Override
    public T remove(int index) {
        T removed = this.backingList.remove(index);
        if (removed != null) {
            this.notifyChange(removed, false);
        }

        return removed;
    }

    @Override
    public int indexOf(Object o) {
        return this.backingList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.backingList.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return this.backingList.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return this.backingList.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return this.backingList.subList(fromIndex, toIndex);
    }

    protected void makeSpace() {
        // Default removal method; Remove index 0. Can be overriden later to change behavior
        this.remove(0);
    }

    protected void notifyChange(T val, boolean removed) {
        this.listeners.forEach(listener -> listener.onListChange(this, val, removed));
    }

    protected void ensureSpace() {
        if (!this.isFull()) {
            return;
        }

        this.makeSpace();
    }
}
