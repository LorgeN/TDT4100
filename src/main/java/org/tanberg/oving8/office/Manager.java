package org.tanberg.oving8.office;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class Manager implements Employee {

    private final Collection<Employee> employees;
    private Iterator<Employee> employeeIterator;

    public Manager(Collection<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Please provide at least one slav... employee");
        }

        this.employees = employees;
        this.employeeIterator = this.employees.iterator();
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        return this.getNextPoorEmployee().doCalculations(operation, value1, value2);
    }

    @Override
    public void printDocument(String document) {
        this.getNextPoorEmployee().printDocument(document);
    }

    @Override
    public int getTaskCount() {
        return this.employees.stream().mapToInt(Employee::getTaskCount).sum();
    }

    @Override
    public int getResourceCount() {
        return 1 + this.employees.stream().mapToInt(Employee::getResourceCount).sum();
    }

    private Employee getNextPoorEmployee() {
        if (!this.employeeIterator.hasNext()) {
            this.employeeIterator = this.employees.iterator();
        }

        return this.employeeIterator.next();
    }
}
