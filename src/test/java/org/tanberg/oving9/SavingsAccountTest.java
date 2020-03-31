package org.tanberg.oving9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {

    private SavingsAccount savingsAccount;

    private SavingsAccount _init_savingsAccount() {
        return new SavingsAccount(0.10);
    }

    @Before
    public void setUp() {
        this.savingsAccount = this._init_savingsAccount();
    }

    private boolean operator_equals(final double d1, final double d2) {
        boolean _xblockexpression;
        final double epsilon = 0.000001d;
        _xblockexpression = (((d1 - epsilon) < d2) && ((d1 + epsilon) > d2));
        return _xblockexpression;
    }

    @Test
    public void testBalanceField() {
        this._transition_exprAction__balanceField_transitions0_actions0(this.savingsAccount);
        this._test__balanceField_transitions0_effects0_state(this.savingsAccount);

    }

    @Test
    public void testDepositAndWithdraw() {
        this._transition_exprAction__depositAndWithdraw_transitions0_actions0(this.savingsAccount);
        this._transition_exprAction__depositAndWithdraw_transitions0_actions1(this.savingsAccount);
        this._test__depositAndWithdraw_transitions0_effects0_state(this.savingsAccount);

    }

    @Test
    public void testDepositAndWithdrawIllegalStateOrInput() {
        try {
            this._transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions0_actions0(this.savingsAccount);
            this._transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions0_actions1(this.savingsAccount);
            Assert.fail("IllegalArgumentException should be thrown after savingsAccount.deposit(10.0), savingsAccount.deposit(-100.0)");
        } catch (Exception e) {
            Assert.assertTrue("IllegalArgumentException should be thrown after savingsAccount.deposit(10.0), savingsAccount.deposit(-100.0)", e instanceof IllegalArgumentException);
        }
        this._test__depositAndWithdrawIllegalStateOrInput_transitions1_effects0_state(this.savingsAccount);
        try {
            this._transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions2_actions0(this.savingsAccount);
            this._transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions2_actions1(this.savingsAccount);
            Assert.fail("IllegalArgumentException should be thrown after savingsAccount.deposit(10.0), savingsAccount.withdraw(-100.0)");
        } catch (Exception e_1) {
            Assert.assertTrue("IllegalArgumentException should be thrown after savingsAccount.deposit(10.0), savingsAccount.withdraw(-100.0)", e_1 instanceof IllegalArgumentException);
        }
        this._test__depositAndWithdrawIllegalStateOrInput_transitions3_effects0_state(this.savingsAccount);
        try {
            this._transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions4_actions0(this.savingsAccount);
            this._transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions4_actions1(this.savingsAccount);
            Assert.fail("IllegalStateException should be thrown after savingsAccount.deposit(10.0), savingsAccount.withdraw(40.0)");
        } catch (Exception e_2) {
            Assert.assertTrue("IllegalStateException should be thrown after savingsAccount.deposit(10.0), savingsAccount.withdraw(40.0)", e_2 instanceof IllegalStateException);
        }
        this._test__depositAndWithdrawIllegalStateOrInput_transitions5_effects0_state(this.savingsAccount);

    }

    @Test
    public void testEndYearUpdate() {
        this._transition_exprAction__endYearUpdate_transitions0_actions0(this.savingsAccount);
        this._transition_exprAction__endYearUpdate_transitions0_actions1(this.savingsAccount);
        this._test__endYearUpdate_transitions0_effects0_state(this.savingsAccount);

    }

    private void _transition_exprAction__balanceField_transitions0_actions0(final SavingsAccount it) {
        try {

            this.savingsAccount.deposit(100.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.deposit(100.0) failed: " + error.getMessage());
        }

    }

    private void _test__balanceField_transitions0_effects0_state(final SavingsAccount it) {
        this._test__balanceField_transitions0_effects0_state_objectTests0_test(this.savingsAccount);

    }

    private void _test__balanceField_transitions0_effects0_state_objectTests0_test(final SavingsAccount it) {

        double _balance = this.savingsAccount.getBalance();
        Assert.assertTrue("savingsAccount.balance == 100.0 failed after savingsAccount.deposit(100.0)", this.operator_equals(_balance, 100.0));

    }

    private void _transition_exprAction__depositAndWithdraw_transitions0_actions0(final SavingsAccount it) {
        try {

            this.savingsAccount.deposit(100.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.deposit(100.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__depositAndWithdraw_transitions0_actions1(final SavingsAccount it) {
        try {

            this.savingsAccount.withdraw(40.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.withdraw(40.0) failed: " + error.getMessage());
        }

    }

    private void _test__depositAndWithdraw_transitions0_effects0_state(final SavingsAccount it) {
        this._test__depositAndWithdraw_transitions0_effects0_state_objectTests0_test(this.savingsAccount);

    }

    private void _test__depositAndWithdraw_transitions0_effects0_state_objectTests0_test(final SavingsAccount it) {

        double _balance = this.savingsAccount.getBalance();
        Assert.assertTrue("savingsAccount.balance == 60.0 failed after savingsAccount.deposit(100.0) ,savingsAccount.withdraw(40.0)", this.operator_equals(_balance, 60.0));

    }

    private void _transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions0_actions0(final SavingsAccount it) {
        try {

            this.savingsAccount.deposit(10.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.deposit(10.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions0_actions1(final SavingsAccount it) {
        try {

            this.savingsAccount.deposit((-100.0));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.deposit(-100.0) failed: " + error.getMessage());
        }

    }

    private void _test__depositAndWithdrawIllegalStateOrInput_transitions1_effects0_state(final SavingsAccount it) {
        this._test__depositAndWithdrawIllegalStateOrInput_transitions1_effects0_state_objectTests0_test(this.savingsAccount);

    }

    private void _test__depositAndWithdrawIllegalStateOrInput_transitions1_effects0_state_objectTests0_test(final SavingsAccount it) {

        double _balance = this.savingsAccount.getBalance();
        Assert.assertTrue("savingsAccount.balance == 10.0 failed", this.operator_equals(_balance, 10.0));

    }

    private void _transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions2_actions0(final SavingsAccount it) {
        try {

            this.savingsAccount.deposit(10.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.deposit(10.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions2_actions1(final SavingsAccount it) {
        try {

            this.savingsAccount.withdraw((-100.0));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.withdraw(-100.0) failed: " + error.getMessage());
        }

    }

    private void _test__depositAndWithdrawIllegalStateOrInput_transitions3_effects0_state(final SavingsAccount it) {
        this._test__depositAndWithdrawIllegalStateOrInput_transitions3_effects0_state_objectTests0_test(this.savingsAccount);

    }

    private void _test__depositAndWithdrawIllegalStateOrInput_transitions3_effects0_state_objectTests0_test(final SavingsAccount it) {

        double _balance = this.savingsAccount.getBalance();
        Assert.assertTrue("savingsAccount.balance == 20.0 failed", this.operator_equals(_balance, 20.0));

    }

    private void _transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions4_actions0(final SavingsAccount it) {
        try {

            this.savingsAccount.deposit(10.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.deposit(10.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__depositAndWithdrawIllegalStateOrInput_transitions4_actions1(final SavingsAccount it) {
        try {

            this.savingsAccount.withdraw(40.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.withdraw(40.0) failed: " + error.getMessage());
        }

    }

    private void _test__depositAndWithdrawIllegalStateOrInput_transitions5_effects0_state(final SavingsAccount it) {
        this._test__depositAndWithdrawIllegalStateOrInput_transitions5_effects0_state_objectTests0_test(this.savingsAccount);

    }

    private void _test__depositAndWithdrawIllegalStateOrInput_transitions5_effects0_state_objectTests0_test(final SavingsAccount it) {

        double _balance = this.savingsAccount.getBalance();
        Assert.assertTrue("savingsAccount.balance == 30.0 failed", this.operator_equals(_balance, 30.0));

    }

    private void _transition_exprAction__endYearUpdate_transitions0_actions0(final SavingsAccount it) {
        try {

            this.savingsAccount.deposit(100.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.deposit(100.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__endYearUpdate_transitions0_actions1(final SavingsAccount it) {
        try {

            this.savingsAccount.endYearUpdate();
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("savingsAccount.endYearUpdate() failed: " + error.getMessage());
        }

    }

    private void _test__endYearUpdate_transitions0_effects0_state(final SavingsAccount it) {
        this._test__endYearUpdate_transitions0_effects0_state_objectTests0_test(this.savingsAccount);

    }

    private void _test__endYearUpdate_transitions0_effects0_state_objectTests0_test(final SavingsAccount it) {

        double _balance = this.savingsAccount.getBalance();
        Assert.assertTrue("savingsAccount.balance == 100.0 * (1 + 0.10) failed after savingsAccount.deposit(100.0) ,savingsAccount.endYearUpdate()", this.operator_equals(_balance, (100.0 * (1 + 0.10))));

    }
}

