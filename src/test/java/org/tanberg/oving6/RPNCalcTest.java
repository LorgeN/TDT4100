package org.tanberg.oving6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPNCalcTest {

    RPNCalc calc;

    @Before
    public void setUp() throws Exception {
        calc = new RPNCalc();
    }

    @Test
    public void testPerformOperationWithoutOperation() {
        try {
            calc.performOperation('+');
        } catch (UnsupportedOperationException e) {
            return;
        }

        Assert.fail("An UnsupportedOperationException should be thrown when performing removed operation");
    }

    @Test
    public void testPerformOperation() {
        calc.addOperator('+', (a, b) -> a * b); // Use "incorrect" definition to filter out cheating
        calc.addOperator('l', (a, b) -> a * (a + b));
        calc.push(4);
        calc.push(3);
        calc.performOperation('+');

        Assert.assertEquals("Operation failed", 12.0, calc.pop(), 0.0);
        Assert.assertEquals("Previous values are not popped from the stack before performing an operation", Double.NaN, calc.pop(), 0.0);

        calc.push(4);
        calc.push(3);
        calc.performOperation('l');

        Assert.assertEquals("Operation failed", 28.0, calc.pop(), 0.0);
        Assert.assertEquals("Previous values are not popped from the stack before performing an operation", Double.NaN, calc.pop(), 0.0);
    }

    @Test
    public void testAddOperator() {
        Assert.assertTrue("Adding first operator returned false", calc.addOperator('+', Double::sum));
        Assert.assertTrue("Adding second, different, operator returned false", calc.addOperator('-', (a, b) -> a - b));
        Assert.assertFalse("Adding duplicate operator returned true", calc.addOperator('+', Double::sum));
        Assert.assertFalse("Adding duplicate operator with different definition returned true", calc.addOperator('-', (a, b) -> a * b));
    }

    @Test
    public void testRemoveOperator() {
        calc.addOperator('+', Double::sum);
        calc.removeOperator('+');

        try {
            calc.performOperation('+');
        } catch (UnsupportedOperationException e) {
            return;
        }

        Assert.fail("An UnsupportedOperationException should be thrown when performing an operation that has been removed");
    }

}

