package org.tanberg.oving9;

public interface ListChangeListener<T> {

    void onListChange(ObservableList<T> list, T value, boolean added);
}
