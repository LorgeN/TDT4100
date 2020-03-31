package org.tanberg.oving9;

import junit.framework.TestCase;
import org.junit.Assert;

public class BSUTest extends TestCase {
    private BSU bsu;

    private BSU _init_bsu() {
        return new BSU(0.05, 25000.0);
    }

    @Override
    protected void setUp() {
        this.bsu = this._init_bsu();
    }

    public void testDeposit() {
        this._transition_exprAction__deposit_transitions0_actions0(this.bsu);
        this._test__deposit_transitions0_effects0_state(this.bsu);
        try {
            this._transition_exprAction__deposit_transitions1_actions0(this.bsu);
            fail("IllegalArgumentException should be thrown after bsu.deposit(-10000.0)");
        } catch (Exception e) {
            assertTrue("IllegalArgumentException should be thrown after bsu.deposit(-10000.0)", e instanceof IllegalArgumentException);
        }
        this._test__deposit_transitions2_effects0_state(this.bsu);
        try {
            this._transition_exprAction__deposit_transitions3_actions0(this.bsu);
            fail("IllegalStateException should be thrown after bsu.deposit(20000.0)");
        } catch (Exception e_1) {
            assertTrue("IllegalStateException should be thrown after bsu.deposit(20000.0)", e_1 instanceof IllegalStateException);
        }
        this._test__deposit_transitions4_effects0_state(this.bsu);
        this._transition_exprAction__deposit_transitions5_actions0(this.bsu);
        this._transition_exprAction__deposit_transitions5_actions1(this.bsu);
        this._test__deposit_transitions5_effects0_state(this.bsu);

    }

    public void testWithdraw() {
        this._transition_exprAction__withdraw_transitions0_actions0(this.bsu);
        this._transition_exprAction__withdraw_transitions0_actions1(this.bsu);
        this._test__withdraw_transitions0_effects0_state(this.bsu);
        try {
            this._transition_exprAction__withdraw_transitions1_actions0(this.bsu);
            fail("IllegalArgumentException should be thrown after bsu.withdraw(-10000.0)");
        } catch (Exception e) {
            assertTrue("IllegalArgumentException should be thrown after bsu.withdraw(-10000.0)", e instanceof IllegalArgumentException);
        }
        this._test__withdraw_transitions2_effects0_state(this.bsu);
        try {
            this._transition_exprAction__withdraw_transitions3_actions0(this.bsu);
            fail("IllegalStateException should be thrown after bsu.withdraw(20000.0)");
        } catch (Exception e_1) {
            assertTrue("IllegalStateException should be thrown after bsu.withdraw(20000.0)", e_1 instanceof IllegalStateException);
        }
        this._test__withdraw_transitions4_effects0_state(this.bsu);
        try {
            this._transition_exprAction__withdraw_transitions5_actions0(this.bsu);
            this._transition_exprAction__withdraw_transitions5_actions1(this.bsu);
            fail("IllegalStateException should be thrown after bsu.endYearUpdate(), bsu.withdraw(10000.0)");
        } catch (Exception e_2) {
            assertTrue("IllegalStateException should be thrown after bsu.endYearUpdate(), bsu.withdraw(10000.0)", e_2 instanceof IllegalStateException);
        }
        this._test__withdraw_transitions6_effects0_state(this.bsu);

    }

    public void testGetTaxDeduction() {
        this._transition_exprAction__getTaxDeduction_transitions0_actions0(this.bsu);
        this._test__getTaxDeduction_transitions0_effects0_state(this.bsu);
        this._transition_exprAction__getTaxDeduction_transitions1_actions0(this.bsu);
        this._transition_exprAction__getTaxDeduction_transitions1_actions1(this.bsu);
        this._test__getTaxDeduction_transitions1_effects0_state(this.bsu);
        this._transition_exprAction__getTaxDeduction_transitions2_actions0(this.bsu);
        this._test__getTaxDeduction_transitions2_effects0_state(this.bsu);

    }

    private void _transition_exprAction__deposit_transitions0_actions0(final BSU it) {
        try {

            this.bsu.deposit(10000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.deposit(10000.0) failed: " + error.getMessage());
        }

    }

    private void _test__deposit_transitions0_effects0_state(final BSU it) {
        this._test__deposit_transitions0_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__deposit_transitions0_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, 10000.0, 0.0d);
    }

    private void _transition_exprAction__deposit_transitions1_actions0(final BSU it) {
        try {

            this.bsu.deposit((-10000.0));
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.deposit(-10000.0) failed: " + error.getMessage());
        }

    }

    private void _test__deposit_transitions2_effects0_state(final BSU it) {
        this._test__deposit_transitions2_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__deposit_transitions2_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, 10000.0, 0.0d);
    }

    private void _transition_exprAction__deposit_transitions3_actions0(final BSU it) {
        try {

            this.bsu.deposit(20000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.deposit(20000.0) failed: " + error.getMessage());
        }

    }

    private void _test__deposit_transitions4_effects0_state(final BSU it) {
        this._test__deposit_transitions4_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__deposit_transitions4_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, 10000.0, 0.0d);

    }

    private void _transition_exprAction__deposit_transitions5_actions0(final BSU it) {
        try {

            this.bsu.endYearUpdate();
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.endYearUpdate() failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__deposit_transitions5_actions1(final BSU it) {
        try {

            this.bsu.deposit(20000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.deposit(20000.0) failed: " + error.getMessage());
        }

    }

    private void _test__deposit_transitions5_effects0_state(final BSU it) {
        this._test__deposit_transitions5_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__deposit_transitions5_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, ((10000.0 * (1 + 0.05)) + 20000.0), 0.0d);
    }

    private void _transition_exprAction__withdraw_transitions0_actions0(final BSU it) {
        try {

            this.bsu.deposit(20000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.deposit(20000.0) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__withdraw_transitions0_actions1(final BSU it) {
        try {

            this.bsu.withdraw(5000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.withdraw(5000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions0_effects0_state(final BSU it) {
        this._test__withdraw_transitions0_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__withdraw_transitions0_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, 15000.0, 0.0d);

    }

    private void _transition_exprAction__withdraw_transitions1_actions0(final BSU it) {
        try {

            this.bsu.withdraw((-10000.0));
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.withdraw(-10000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions2_effects0_state(final BSU it) {
        this._test__withdraw_transitions2_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__withdraw_transitions2_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, 15000.0, 0.0d);
    }

    private void _transition_exprAction__withdraw_transitions3_actions0(final BSU it) {
        try {

            this.bsu.withdraw(20000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.withdraw(20000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions4_effects0_state(final BSU it) {
        this._test__withdraw_transitions4_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__withdraw_transitions4_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, 15000.0, 0.0d);

    }

    private void _transition_exprAction__withdraw_transitions5_actions0(final BSU it) {
        try {

            this.bsu.endYearUpdate();
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.endYearUpdate() failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__withdraw_transitions5_actions1(final BSU it) {
        try {

            this.bsu.withdraw(10000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.withdraw(10000.0) failed: " + error.getMessage());
        }

    }

    private void _test__withdraw_transitions6_effects0_state(final BSU it) {
        this._test__withdraw_transitions6_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__withdraw_transitions6_effects0_state_objectTests0_test(final BSU it) {

        double _balance = this.bsu.getBalance();
        Assert.assertEquals(_balance, (15000.0 * (1 + 0.05)), 0.0d);

    }

    private void _transition_exprAction__getTaxDeduction_transitions0_actions0(final BSU it) {
        try {

            this.bsu.deposit(20000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.deposit(20000.0) failed: " + error.getMessage());
        }

    }

    private void _test__getTaxDeduction_transitions0_effects0_state(final BSU it) {
        this._test__getTaxDeduction_transitions0_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__getTaxDeduction_transitions0_effects0_state_objectTests0_test(final BSU it) {

        double _taxDeduction = this.bsu.getTaxDeduction();
        Assert.assertEquals(_taxDeduction, (20000.0 * 0.20), 0.0d);

    }

    private void _transition_exprAction__getTaxDeduction_transitions1_actions0(final BSU it) {
        try {

            this.bsu.endYearUpdate();
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.endYearUpdate failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__getTaxDeduction_transitions1_actions1(final BSU it) {
        try {

            this.bsu.deposit(10000.0);
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.deposit(10000.0) failed: " + error.getMessage());
        }

    }

    private void _test__getTaxDeduction_transitions1_effects0_state(final BSU it) {
        this._test__getTaxDeduction_transitions1_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__getTaxDeduction_transitions1_effects0_state_objectTests0_test(final BSU it) {

        double _taxDeduction = this.bsu.getTaxDeduction();
        Assert.assertEquals(_taxDeduction, (10000.0 * 0.20), 0.0d);

    }

    private void _transition_exprAction__getTaxDeduction_transitions2_actions0(final BSU it) {
        try {

            this.bsu.endYearUpdate();
        } catch (junit.framework.AssertionFailedError error) {
            fail("bsu.endYearUpdate failed: " + error.getMessage());
        }

    }

    private void _test__getTaxDeduction_transitions2_effects0_state(final BSU it) {
        this._test__getTaxDeduction_transitions2_effects0_state_objectTests0_test(this.bsu);

    }

    private void _test__getTaxDeduction_transitions2_effects0_state_objectTests0_test(final BSU it) {

        double _taxDeduction = this.bsu.getTaxDeduction();
        Assert.assertEquals(_taxDeduction, 0.0, 0.0d);

    }
}

