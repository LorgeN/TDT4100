package org.tanberg.oving6;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {

    private final StringGrid grid;
    private final boolean rowMajor;
    private int minor;
    private int major;
    private int maxMinor;
    private int maxMajor;

    public StringGridIterator(StringGrid grid, boolean rowMajor) {
        this.grid = grid;
        this.rowMajor = rowMajor;

        this.minor = this.major = 0;

        this.maxMinor = rowMajor ? grid.getColumnCount() : grid.getRowCount();
        this.maxMajor = rowMajor ? grid.getRowCount() : grid.getColumnCount();
    }

    @Override
    public boolean hasNext() {
        return this.major < this.maxMajor;
    }

    @Override
    public String next() {
        int row = this.rowMajor ? this.major : this.minor;
        int column = this.rowMajor ? this.minor : this.major;
        String str = this.grid.getElement(row, column);
        if (++this.minor >= this.maxMinor) {
            this.minor = 0;
            ++this.major;
        }

        return str;
    }
}
