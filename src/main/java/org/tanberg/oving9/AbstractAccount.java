package org.tanberg.oving9;

public abstract class AbstractAccount {

    // Automatically defaults to 0
    protected double balance;

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Provide a positive amount!");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException, IllegalStateException {
        if (amount < 0) {
            throw new IllegalArgumentException("Provide a positive amount!");
        }

        this.internalWithdraw(amount);
    }

    abstract void internalWithdraw(double amount) throws IllegalStateException;

    public double getBalance() {
        return this.balance;
    }
}
