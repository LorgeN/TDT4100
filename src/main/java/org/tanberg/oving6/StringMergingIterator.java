package org.tanberg.oving6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

    private final Iterator<String> first;
    private final Iterator<String> second;
    private boolean turnSwitch;

    public StringMergingIterator(Iterator<String> first, Iterator<String> second) {
        this.first = first;
        this.second = second;
        this.turnSwitch = true;
    }

    @Override
    public boolean hasNext() {
        return this.first.hasNext() || this.second.hasNext();
    }

    @Override
    public String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }

        if (!this.first.hasNext()) {
            return this.second.next();
        }

        if (!this.second.hasNext()) {
            return this.first.next();
        }

        return (this.turnSwitch = !this.turnSwitch) ? this.second.next() : this.first.next();
    }
}

