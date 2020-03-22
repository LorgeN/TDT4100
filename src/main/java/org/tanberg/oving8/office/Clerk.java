package org.tanberg.oving8.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {

    private final Printer printer;
    private int taskCount;

    public Clerk(Printer printer) {
        this.printer = printer;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        this.taskCount++;
        return operation.apply(value1, value2);
    }

    @Override
    public void printDocument(String document) {
        this.taskCount++;
        this.printer.printDocument(document, this);
    }

    @Override
    public int getTaskCount() {
        return this.taskCount;
    }

    @Override
    public int getResourceCount() {
        return 1;
    }
}
