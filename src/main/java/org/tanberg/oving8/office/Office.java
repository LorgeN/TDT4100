package org.tanberg.oving8.office;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Office {

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    public static Manager createTree(int levels) {
        if (levels <= 1) {
            return createClerkManager();
        }

        return new Manager(createEmployees(() -> createTree(levels - 1)));
    }

    public static List<Employee> createClerks() {
        Printer printer = new Printer();
        return createEmployees(() -> new Clerk(printer));
    }

    public static List<Employee> createEmployees(Supplier<Employee> supplier) {
        int count = ThreadLocalRandom.current().nextInt(5, 15);
        return Stream.generate(supplier).limit(count).collect(Collectors.toList());
    }

    public static Manager createClerkManager() {
        Printer printer = new Printer();
        return createManager(() -> new Clerk(printer));
    }

    public static Manager createManager(Supplier<Employee> employeeSupplier) {
        return new Manager(createEmployees(employeeSupplier));
    }

    public static void main(String[] args) {
        double[] efficiencies = new double[5];
        for (int i = 1; i <= 5; i++) {
            Manager bigBoss = createTree(i);

            for (int taskIndex = 1; taskIndex <= 1000; taskIndex++) {
                bigBoss.doCalculations(Double::sum, 1.0d * taskIndex, 1.5d * taskIndex);
                bigBoss.printDocument("Document #" + taskIndex);
            }

            efficiencies[i - 1] = (double) bigBoss.getTaskCount() / (double) bigBoss.getResourceCount();
        }

        for (int i = 1; i <= efficiencies.length; i++) {
            System.out.println("Efficiency level " + i + ": " + FORMAT.format(efficiencies[i - 1]) + "%");
        }
    }
}
