package org.tanberg.oving9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForeldreSparTest {

    private ForeldreSpar foreldreSpar;

    private ForeldreSpar _init_foreldreSpar() {
        return new ForeldreSpar(0.04, 3);
    }

    @Before
    public void setUp() {
        this.foreldreSpar = this._init_foreldreSpar();
    }

    private boolean operator_equals(final double n1, final double n2) {
        boolean _xblockexpression;
        final double epsilon = 0.0000001;
        _xblockexpression = (((n1 - epsilon) < n2) && ((n1 + epsilon) > n2));
        return _xblockexpression;
    }

    @Test
    public void testWithdraw() {
        this._transition_exprAction__withdraw_transitions0_actions0(this.foreldreSpar);
        this._transition_exprAction__withdraw_transitions0_actions1(this.foreldreSpar);
        this._test__withdraw_transitions0_effects0_state(this.foreldreSpar);

        try {
            this._transition_exprAction__withdraw_transitions1_actions0(this.foreldreSpar);
            Assert.fail("IllegalArgumentException should be thrown after foreldreSpar.withdraw(-1000.0)");
        } catch (Exception e) {
            Assert.assertTrue("IllegalArgumentException should be thrown after foreldreSpar.withdraw(-1000.0)", e instanceof IllegalArgumentException);
        }

        this._test__withdraw_transitions2_effects0_state(this.foreldreSpar);

        try {
            this._transition_exprAction__withdraw_transitions3_actions0(this.foreldreSpar);
            Assert.fail("IllegalStateException should be thrown after foreldreSpar.withdraw(10000.0)");
        } catch (Exception e_1) {
            Assert.assertTrue("IllegalStateException should be thrown after foreldreSpar.withdraw(10000.0)", e_1 instanceof IllegalStateException);
        }

        this._test__withdraw_transitions4_effects0_state(this.foreldreSpar);

        try {
            this._transition_exprAction__withdraw_transitions5_actions0(this.foreldreSpar);
            this._transition_exprAction__withdraw_transitions5_actions1(this.foreldreSpar);
            this._transition_exprAction__withdraw_transitions5_actions2(this.foreldreSpar);
            Assert.fail("IllegalStateException should be thrown after foreldreSpar.withdraw(1000.0), foreldreSpar.withdraw(1000.0), foreldreSpar.withdraw(1000.0)");
        } catch (Exception e_2) {
            Assert.assertTrue("IllegalStateException should be thrown after foreldreSpar.withdraw(1000.0), foreldreSpar.withdraw(1000.0), foreldreSpar.withdraw(1000.0)", e_2 instanceof IllegalStateException);
        }

        this._test__withdraw_transitions6_effects0_state(this.foreldreSpar);
        this._transition_exprAction__withdraw_transitions7_actions0(this.foreldreSpar);
        this._transition_exprAction__withdraw_transitions7_actions1(this.foreldreSpar);
        this._test__withdraw_transitions7_effects0_state(this.foreldreSpar);

    }

    @Test
    public void testGetRemainingWithdrawals() {
        this._transition_exprAction__getRemainingWithdrawals_transitions0_actions0(this.foreldreSpar);
        this._transition_exprAction__getRemainingWithdrawals_transitions0_actions1(this.foreldreSpar);
        this._test__getRemainingWithdrawals_transitions0_effects0_state(this.foreldreSpar);
        this._transition_exprAction__getRemainingWithdrawals_transitions1_actions0(this.foreldreSpar);
        this._transition_exprAction__getRemainingWithdrawals_transitions1_actions1(this.foreldreSpar);
        this._test__getRemainingWithdrawals_transitions1_effects0_state(this.foreldreSpar);

        try {
            this._transition_exprAction__getRemainingWithdrawals_transitions2_actions0(this.foreldreSpar);
            Assert.fail("IllegalStateException should be thrown after foreldreSpar.withdraw(1000.0)");
        } catch (Exception e) {
            Assert.assertTrue("IllegalStateException should be thrown after foreldreSpar.withdraw(1000.0)", e instanceof IllegalStateException);
        }

        this._test__getRemainingWithdrawals_transitions3_effects0_state(this.foreldreSpar);
        this._transition_exprAction__getRemainingWithdrawals_transitions4_actions0(this.foreldreSpar);
        this._test__getRemainingWithdrawals_transitions4_effects0_state(this.foreldreSpar);

    }

    private void _transition_exprAction__withdraw_transitions0_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.deposit(10000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.deposit(10000.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__withdraw_transitions0_actions1(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions0_effects0_state(final ForeldreSpar it) {
        this._test__withdraw_transitions0_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__withdraw_transitions0_effects0_state_objectTests0_test(final ForeldreSpar it) {

        double _balance = this.foreldreSpar.getBalance();
        Assert.assertTrue("foreldreSpar.getBalance() == 9000.0 failed after foreldreSpar.deposit(10000.0) ,foreldreSpar.withdraw(1000.0)", this.operator_equals(_balance, 9000.0));

    }

    private void _transition_exprAction__withdraw_transitions1_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw((-1000.0));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(-1000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions2_effects0_state(final ForeldreSpar it) {
        this._test__withdraw_transitions2_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__withdraw_transitions2_effects0_state_objectTests0_test(final ForeldreSpar it) {

        double _balance = this.foreldreSpar.getBalance();
        Assert.assertTrue("foreldreSpar.getBalance() == 9000.0 failed", this.operator_equals(_balance, 9000.0));

    }

    private void _transition_exprAction__withdraw_transitions3_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(10000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(10000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions4_effects0_state(final ForeldreSpar it) {
        this._test__withdraw_transitions4_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__withdraw_transitions4_effects0_state_objectTests0_test(final ForeldreSpar it) {

        double _balance = this.foreldreSpar.getBalance();
        Assert.assertTrue("foreldreSpar.getBalance() == 9000.0 failed", this.operator_equals(_balance, 9000.0));

    }

    private void _transition_exprAction__withdraw_transitions5_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__withdraw_transitions5_actions1(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__withdraw_transitions5_actions2(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions6_effects0_state(final ForeldreSpar it) {
        this._test__withdraw_transitions6_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__withdraw_transitions6_effects0_state_objectTests0_test(final ForeldreSpar it) {

        double _balance = this.foreldreSpar.getBalance();
        Assert.assertTrue("foreldreSpar.getBalance() == 7000.0 failed", this.operator_equals(_balance, 7000.0));

    }

    private void _transition_exprAction__withdraw_transitions7_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.endYearUpdate();
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.endYearUpdate() failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__withdraw_transitions7_actions1(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions7_effects0_state(final ForeldreSpar it) {
        this._test__withdraw_transitions7_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__withdraw_transitions7_effects0_state_objectTests0_test(final ForeldreSpar it) {

        double _balance = this.foreldreSpar.getBalance();
        Assert.assertTrue("foreldreSpar.getBalance() == 7000.0 * (1 + 0.04) - 1000.0 failed after foreldreSpar.endYearUpdate() ,foreldreSpar.withdraw(1000.0)", this.operator_equals(_balance, ((7000.0 * (1 + 0.04)) - 1000.0)));

    }

    private void _transition_exprAction__getRemainingWithdrawals_transitions0_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.deposit(10000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.deposit(10000.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__getRemainingWithdrawals_transitions0_actions1(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _test__getRemainingWithdrawals_transitions0_effects0_state(final ForeldreSpar it) {
        this._test__getRemainingWithdrawals_transitions0_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__getRemainingWithdrawals_transitions0_effects0_state_objectTests0_test(final ForeldreSpar it) {

        int _remainingWithdrawals = this.foreldreSpar.getRemainingWithdrawals();
        Assert.assertTrue("foreldreSpar.getRemainingWithdrawals() == 2 failed after foreldreSpar.deposit(10000.0) ,foreldreSpar.withdraw(1000.0)", this.operator_equals(_remainingWithdrawals, 2));

    }

    private void _transition_exprAction__getRemainingWithdrawals_transitions1_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__getRemainingWithdrawals_transitions1_actions1(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _test__getRemainingWithdrawals_transitions1_effects0_state(final ForeldreSpar it) {
        this._test__getRemainingWithdrawals_transitions1_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__getRemainingWithdrawals_transitions1_effects0_state_objectTests0_test(final ForeldreSpar it) {

        int _remainingWithdrawals = this.foreldreSpar.getRemainingWithdrawals();
        Assert.assertTrue("foreldreSpar.getRemainingWithdrawals() == 0 failed after foreldreSpar.withdraw(1000.0) ,foreldreSpar.withdraw(1000.0)", this.operator_equals(_remainingWithdrawals, 0));

    }

    private void _transition_exprAction__getRemainingWithdrawals_transitions2_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.withdraw(1000.0);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.withdraw(1000.0) failed: " + error.getMessage());
        }

    }

    private void _test__getRemainingWithdrawals_transitions3_effects0_state(final ForeldreSpar it) {
        this._test__getRemainingWithdrawals_transitions3_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__getRemainingWithdrawals_transitions3_effects0_state_objectTests0_test(final ForeldreSpar it) {

        int _remainingWithdrawals = this.foreldreSpar.getRemainingWithdrawals();
        Assert.assertTrue("foreldreSpar.getRemainingWithdrawals() == 0 failed", this.operator_equals(_remainingWithdrawals, 0));

    }

    private void _transition_exprAction__getRemainingWithdrawals_transitions4_actions0(final ForeldreSpar it) {
        try {

            this.foreldreSpar.endYearUpdate();
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("foreldreSpar.endYearUpdate() failed: " + error.getMessage());
        }

    }

    private void _test__getRemainingWithdrawals_transitions4_effects0_state(final ForeldreSpar it) {
        this._test__getRemainingWithdrawals_transitions4_effects0_state_objectTests0_test(this.foreldreSpar);

    }

    private void _test__getRemainingWithdrawals_transitions4_effects0_state_objectTests0_test(final ForeldreSpar it) {

        int _remainingWithdrawals = this.foreldreSpar.getRemainingWithdrawals();
        Assert.assertTrue("foreldreSpar.getRemainingWithdrawals() == 3 failed after foreldreSpar.endYearUpdate()", this.operator_equals(_remainingWithdrawals, 3));

    }
}

