package org.tanberg.oving9;

public class BSU extends SavingsAccount {

    private final double yearlyLimit;
    private double yearlyProgress;

    public BSU(double interest, double yearlyLimit) {
        super(interest);
        this.yearlyLimit = yearlyLimit;
    }

    public double getTaxDeduction() {
        return this.yearlyProgress * 0.2;
    }

    @Override
    public void deposit(double amount) throws IllegalArgumentException {
        if ((this.yearlyProgress + amount) > this.yearlyLimit) {
            throw new IllegalStateException("Exceeds yearly limit!");
        }

        super.deposit(amount);
        this.yearlyProgress += amount;
    }

    @Override
    public double getAvailableBalance() {
        return this.yearlyProgress;
    }

    @Override
    public void withdraw(double amount) throws IllegalArgumentException, IllegalStateException {
        super.withdraw(amount);
        this.yearlyProgress -= amount;
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        this.yearlyProgress = 0;
    }
}
