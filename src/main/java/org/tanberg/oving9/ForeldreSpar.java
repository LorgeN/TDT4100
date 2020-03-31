package org.tanberg.oving9;

// E N G L I S H   P L E A S E
public class ForeldreSpar extends SavingsAccount {

    private final int yearlyWithdrawalLimit;
    private int yearWithdrawals;

    public ForeldreSpar(double interest, int yearlyWithdrawalLimit) {
        super(interest);
        this.yearlyWithdrawalLimit = yearlyWithdrawalLimit;
    }

    public int getRemainingWithdrawals() {
        return this.yearlyWithdrawalLimit - this.yearWithdrawals;
    }

    @Override
    public void withdraw(double amount) throws IllegalArgumentException, IllegalStateException {
        if (this.yearWithdrawals >= this.yearlyWithdrawalLimit) {
            throw new IllegalStateException("Not enough withdrawals left!");
        }

        super.withdraw(amount);
        this.yearWithdrawals++;
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        this.yearWithdrawals = 0;
    }
}
