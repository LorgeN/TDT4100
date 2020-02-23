package org.tanberg.oving6;

public class StringGridImpl implements StringGrid {

    private final String[][] grid;

    public StringGridImpl(int rows, int columns) {
        this.grid = new String[rows][columns];
    }

    @Override
    public int getRowCount() {
        return this.grid.length;
    }

    @Override
    public int getColumnCount() {
        return this.grid[0].length;
    }

    @Override
    public String getElement(int row, int column) {
        if (row >= this.getRowCount() || row < 0) {
            throw new IndexOutOfBoundsException("Row " + row + " out of bounds");
        }

        if (column >= this.getColumnCount() || column < 0) {
            throw new IndexOutOfBoundsException("Column " + column + " out of bounds");
        }

        return this.grid[row][column];
    }

    @Override
    public void setElement(int row, int column, String element) {
        if (row >= this.getRowCount() || row < 0) {
            throw new IndexOutOfBoundsException("Row " + row + " out of bounds");
        }

        if (column >= this.getColumnCount() || column < 0) {
            throw new IndexOutOfBoundsException("Column " + column + " out of bounds");
        }

        this.grid[row][column] = element;
    }
}
