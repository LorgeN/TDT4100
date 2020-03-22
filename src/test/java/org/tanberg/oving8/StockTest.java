package org.tanberg.oving8;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tanberg.oving8.stocks.Stock;

public class StockTest {

    private Stock stock;

    private Stock _init_stock() {
        return new Stock("APPL", 110.0d);
    }

    private double oldPrice1;

    private double _init_oldPrice1() {
        return 0.0d;
    }

    private double newPrice1;

    private double _init_newPrice1() {
        return 110.0d;
    }

    private double oldPrice2;

    private double _init_oldPrice2() {
        return 0.0d;
    }

    private double newPrice2;

    private double _init_newPrice2() {
        return 0.0d;
    }

    @Before
    public void setUp() {
        stock = _init_stock();
        oldPrice1 = _init_oldPrice1();
        newPrice1 = _init_newPrice1();
        oldPrice2 = _init_oldPrice2();
        newPrice2 = _init_newPrice2();

    }

    private void setPrice1(final double newPrice, final double expectedOldPrice, final double expectedNewPrice) {
        this.oldPrice1 = this.newPrice1;
        this.newPrice1 = newPrice;
        this.stock.setPrice(newPrice);
        TestCase.assertEquals(Double.valueOf(expectedOldPrice), Double.valueOf(this.oldPrice2));
        TestCase.assertEquals(Double.valueOf(expectedNewPrice), Double.valueOf(this.newPrice2));
    }

    private double setPrice2(final double oldPrice, final double newPrice) {
        double _xblockexpression = (double) 0;
        {
            this.oldPrice2 = oldPrice;
            _xblockexpression = this.newPrice2 = newPrice;
        }
        return _xblockexpression;
    }

    @Test
    public void testConstructor() {
        _test__constructor_transitions0_effects0_state();

    }

    @Test
    public void testStockListener() {
        _transition_exprAction__stockListener_transitions0_actions0();
        _transition_exprAction__stockListener_transitions0_actions1();
        _test__stockListener_transitions0_effects0_state();
        _transition_exprAction__stockListener_transitions1_actions0();
        _test__stockListener_transitions1_effects0_state();

    }

    private void _test__constructor_transitions0_effects0_state() {
        _test__constructor_transitions0_effects0_state_objectTests0_test(stock);

    }

    private void _test__constructor_transitions0_effects0_state_objectTests0_test(final Stock it) {

        String _ticker = it.getTicker();
        Assert.assertEquals("ticker == \"APPL\" failed", "APPL", _ticker);

        double _price = it.getPrice();
        Assert.assertEquals("price == 110.0d failed", 110.0d, _price, 0.0d);

    }

    private void _transition_exprAction__stockListener_transitions0_actions0() {
        try {

            this.stock.addStockListener((Stock stock, double oldPrice, double newPrice) -> this.setPrice2(oldPrice, newPrice));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("stock.addStockListener([Stock stock, double oldPrice, double newPrice | setPrice2(oldPrice, newPrice) ]) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__stockListener_transitions0_actions1() {
        try {

            this.setPrice1(118.0d, 110.0d, 118.0d);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("setPrice1(118.0d, 110.0d, 118.0d) failed: " + error.getMessage());
        }

    }

    private void _test__stockListener_transitions0_effects0_state() {
        _test__stockListener_transitions0_effects0_state_objectTests0_test(stock);

    }

    private void _test__stockListener_transitions0_effects0_state_objectTests0_test(final Stock it) {

        double _price = it.getPrice();
        Assert.assertEquals("price == 118.0d failed after stock.addStockListener([Stock stock, double oldPrice, double newPrice | setPrice2(oldPrice, newPrice) ]) ,setPrice1(118.0d, 110.0d, 118.0d)", 118.0d, _price, 0.0d);

    }

    private void _transition_exprAction__stockListener_transitions1_actions0() {
        try {

            this.setPrice1(121.0d, 118.0d, 121.0d);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("setPrice1(121.0d, 118.0d, 121.0d) failed: " + error.getMessage());
        }

    }

    private void _test__stockListener_transitions1_effects0_state() {
        _test__stockListener_transitions1_effects0_state_objectTests0_test(stock);

    }

    private void _test__stockListener_transitions1_effects0_state_objectTests0_test(final Stock it) {

        double _price = it.getPrice();
        Assert.assertEquals("price == 121.0d failed after setPrice1(121.0d, 118.0d, 121.0d)", 121.0d, _price, 0.0d);

    }
}

