package org.tanberg.oving8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tanberg.oving8.stocks.Stock;
import org.tanberg.oving8.stocks.StockIndex;

public class StockIndexTest {
    private double facebookPrice;

    private double _init_facebookPrice() {
        return 67.80;
    }

    private double applePrice;

    private double _init_applePrice() {
        return 534.98;
    }

    private Stock facebook;

    private Stock _init_facebook() {
        return new Stock("FB", this.facebookPrice);
    }

    private Stock apple;

    private Stock _init_apple() {
        return new Stock("AAPL", this.applePrice);
    }

    private StockIndex index0;

    private StockIndex _init_index0() {
        return new StockIndex("OSEBX");
    }

    private StockIndex index1;

    private StockIndex _init_index1() {
        return new StockIndex("OSEBX", this.facebook);
    }

    private StockIndex indexN;

    private StockIndex _init_indexN() {
        return new StockIndex("OSEBX", this.facebook, this.apple);
    }

    @Before
    public void setUp() {
        facebookPrice = _init_facebookPrice();
        applePrice = _init_applePrice();
        facebook = _init_facebook();
        apple = _init_apple();
        index0 = _init_index0();
        index1 = _init_index1();
        indexN = _init_indexN();

    }

    private boolean operator_equals(final double d1, final double d2) {
        boolean _xblockexpression = false;
        {
            final double epsilon = 0.000001d;
            _xblockexpression = (((d1 - epsilon) < d2) && ((d1 + epsilon) > d2));
        }
        return _xblockexpression;
    }

    @Test
    public void testConstructor() {
        _test__constructor_transitions0_effects0_state();

    }

    @Test
    public void testAddStock() {
        _test__addStock_transitions0_effects0_state();
        _transition_exprAction__addStock_transitions1_actions0();
        _test__addStock_transitions1_effects0_state();
        _transition_exprAction__addStock_transitions2_actions0();
        _test__addStock_transitions2_effects0_state();

    }

    @Test
    public void testRemoveStock() {
        _test__removeStock_transitions0_effects0_state();
        _transition_exprAction__removeStock_transitions1_actions0();
        _test__removeStock_transitions1_effects0_state();
        _transition_exprAction__removeStock_transitions2_actions0();
        _test__removeStock_transitions2_effects0_state();
        _transition_exprAction__removeStock_transitions3_actions0();
        _test__removeStock_transitions3_effects0_state();

    }

    @Test
    public void testChangePrice() {
        double facebookPrice2 = _init__changePrice_facebookPrice2();
        double facebookPrice3 = _init__changePrice_facebookPrice3();
        _transition_exprAction__changePrice_transitions0_actions0(facebookPrice2, facebookPrice3);
        _test__changePrice_transitions0_effects0_state(facebookPrice2, facebookPrice3);
        _transition_exprAction__changePrice_transitions1_actions0(facebookPrice2, facebookPrice3);
        _test__changePrice_transitions1_effects0_state(facebookPrice2, facebookPrice3);

    }

    private void _test__constructor_transitions0_effects0_state() {
        _test__constructor_transitions0_effects0_state_objectTests0_test(index0);
        _test__constructor_transitions0_effects0_state_objectTests1_test(index1);
        _test__constructor_transitions0_effects0_state_objectTests2_test(indexN);

    }

    private void _test__constructor_transitions0_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == 0.0 failed", this.operator_equals(_index, 0.0));

    }

    private void _test__constructor_transitions0_effects0_state_objectTests1_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice failed", this.operator_equals(_index, this.facebookPrice));

    }

    private void _test__constructor_transitions0_effects0_state_objectTests2_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice + applePrice failed", this.operator_equals(_index, (this.facebookPrice + this.applePrice)));

    }

    private void _test__addStock_transitions0_effects0_state() {
        _test__addStock_transitions0_effects0_state_objectTests0_test(index0);

    }

    private void _test__addStock_transitions0_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == 0.0 failed", this.operator_equals(_index, 0.0));

    }

    private void _transition_exprAction__addStock_transitions1_actions0() {
        try {

            this.index0.addStock(this.facebook);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("index0.addStock(facebook) failed: " + error.getMessage());
        }

    }

    private void _test__addStock_transitions1_effects0_state() {
        _test__addStock_transitions1_effects0_state_objectTests0_test(index0);

    }

    private void _test__addStock_transitions1_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice failed after index0.addStock(facebook)", this.operator_equals(_index, this.facebookPrice));

    }

    private void _transition_exprAction__addStock_transitions2_actions0() {
        try {

            this.index0.addStock(this.facebook);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("index0.addStock(facebook) failed: " + error.getMessage());
        }

    }

    private void _test__addStock_transitions2_effects0_state() {
        _test__addStock_transitions2_effects0_state_objectTests0_test(index0);

    }

    private void _test__addStock_transitions2_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice failed after index0.addStock(facebook)", this.operator_equals(_index, this.facebookPrice));

    }

    private void _test__removeStock_transitions0_effects0_state() {
        _test__removeStock_transitions0_effects0_state_objectTests0_test(indexN);

    }

    private void _test__removeStock_transitions0_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice + applePrice failed", this.operator_equals(_index, (this.facebookPrice + this.applePrice)));

    }

    private void _transition_exprAction__removeStock_transitions1_actions0() {
        try {

            this.indexN.removeStock(this.apple);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("indexN.removeStock(apple) failed: " + error.getMessage());
        }

    }

    private void _test__removeStock_transitions1_effects0_state() {
        _test__removeStock_transitions1_effects0_state_objectTests0_test(indexN);

    }

    private void _test__removeStock_transitions1_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice failed after indexN.removeStock(apple)", this.operator_equals(_index, this.facebookPrice));

    }

    private void _transition_exprAction__removeStock_transitions2_actions0() {
        try {

            this.indexN.removeStock(this.apple);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("indexN.removeStock(apple) failed: " + error.getMessage());
        }

    }

    private void _test__removeStock_transitions2_effects0_state() {
        _test__removeStock_transitions2_effects0_state_objectTests0_test(indexN);

    }

    private void _test__removeStock_transitions2_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice failed after indexN.removeStock(apple)", this.operator_equals(_index, this.facebookPrice));

    }

    private void _transition_exprAction__removeStock_transitions3_actions0() {
        try {

            this.indexN.removeStock(this.facebook);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("indexN.removeStock(facebook) failed: " + error.getMessage());
        }

    }

    private void _test__removeStock_transitions3_effects0_state() {
        _test__removeStock_transitions3_effects0_state_objectTests0_test(indexN);

    }

    private void _test__removeStock_transitions3_effects0_state_objectTests0_test(final StockIndex it) {

        double _index = it.getIndex();
        Assert.assertTrue("index == 0.0 failed after indexN.removeStock(facebook)", this.operator_equals(_index, 0.0));

    }

    private double _init__changePrice_facebookPrice2() {
        return 67.0;
    }

    private double _init__changePrice_facebookPrice3() {
        return 69.0;
    }

    private void _transition_exprAction__changePrice_transitions0_actions0(final double facebookPrice2, final double facebookPrice3) {
        try {

            this.facebook.setPrice(facebookPrice2);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("facebook.setPrice(facebookPrice2) failed: " + error.getMessage());
        }

    }

    private void _test__changePrice_transitions0_effects0_state(final double facebookPrice2, final double facebookPrice3) {
        _test__changePrice_transitions0_effects0_state_objectTests0_test(index1, facebookPrice2, facebookPrice3);
        _test__changePrice_transitions0_effects0_state_objectTests1_test(indexN, facebookPrice2, facebookPrice3);

    }

    private void _test__changePrice_transitions0_effects0_state_objectTests0_test(final StockIndex it, final double facebookPrice2, final double facebookPrice3) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice2 failed after facebook.setPrice(facebookPrice2)", this.operator_equals(_index, facebookPrice2));

    }

    private void _test__changePrice_transitions0_effects0_state_objectTests1_test(final StockIndex it, final double facebookPrice2, final double facebookPrice3) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice2 + applePrice failed after facebook.setPrice(facebookPrice2)", this.operator_equals(_index, (facebookPrice2 + this.applePrice)));

    }

    private void _transition_exprAction__changePrice_transitions1_actions0(final double facebookPrice2, final double facebookPrice3) {
        try {

            this.facebook.setPrice(facebookPrice3);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("facebook.setPrice(facebookPrice3) failed: " + error.getMessage());
        }

    }

    private void _test__changePrice_transitions1_effects0_state(final double facebookPrice2, final double facebookPrice3) {
        _test__changePrice_transitions1_effects0_state_objectTests0_test(index1, facebookPrice2, facebookPrice3);
        _test__changePrice_transitions1_effects0_state_objectTests1_test(indexN, facebookPrice2, facebookPrice3);

    }

    private void _test__changePrice_transitions1_effects0_state_objectTests0_test(final StockIndex it, final double facebookPrice2, final double facebookPrice3) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice3 failed after facebook.setPrice(facebookPrice3)", this.operator_equals(_index, facebookPrice3));

    }

    private void _test__changePrice_transitions1_effects0_state_objectTests1_test(final StockIndex it, final double facebookPrice2, final double facebookPrice3) {

        double _index = it.getIndex();
        Assert.assertTrue("index == facebookPrice3 + applePrice failed after facebook.setPrice(facebookPrice3)", this.operator_equals(_index, (facebookPrice3 + this.applePrice)));

    }
}

