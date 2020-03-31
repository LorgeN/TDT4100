package org.tanberg.oving9;

public class SavingsAccount implements Account {

    private final double interest;
    private double balance;

    public SavingsAccount(double interest) {
        this.interest = interest;
    }

    public double getAvailableBalance() {
        return this.getBalance();
    }

    @Override
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Provide a positive amount!");
        }

        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) throws IllegalArgumentException, IllegalStateException {
        if (amount < 0) {
            throw new IllegalArgumentException("Provide a positive amount!");
        }

        if (amount > this.getAvailableBalance()) {
            throw new IllegalStateException("Insufficient funds!");
        }

        this.balance -= amount;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    public void endYearUpdate() {
        this.balance += this.balance * this.interest;
    }
}
