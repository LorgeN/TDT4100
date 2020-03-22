package org.tanberg.oving8;

import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tanberg.oving8.office.Clerk;
import org.tanberg.oving8.office.Printer;

import java.util.Collection;
import java.util.function.BinaryOperator;

public class ClerkTest {
    private Printer printer;

    private Printer _init_printer() {
        return new Printer();
    }

    private Clerk clerk;

    private Clerk _init_clerk() {
        return new Clerk(this.printer);
    }

    @Before
    public void setUp() {
        printer = _init_printer();
        clerk = _init_clerk();

    }

    private boolean operator_assertEquals(final double first, final double second) {
        TestCase.assertEquals(first, second, 0.000001d);
        return true;
    }

    @Test
    public void testDoCalculations() {
        _test__doCalculations_transitions0_effect_state();
        _transition_exprAction__doCalculations_transitions1_actions0();
        _test__doCalculations_transitions1_effect_state();
        _transition_exprAction__doCalculations_transitions2_actions0();
        _test__doCalculations_transitions2_effect_state();

    }

    @Test
    public void testPrintDocuments() {
        _test__printDocuments_transitions0_effect_state();
        _transition_exprAction__printDocuments_transitions1_actions0();
        _test__printDocuments_transitions1_effect_state();
        _transition_exprAction__printDocuments_transitions2_actions0();
        _test__printDocuments_transitions2_effect_state();

    }

    @Test
    public void testTaskCount() {
        _test__taskCount_transitions0_effect_state();
        _transition_exprAction__taskCount_transitions1_actions0();
        _test__taskCount_transitions1_effect_state();
        _transition_exprAction__taskCount_transitions2_actions0();
        _test__taskCount_transitions2_effect_state();

    }

    @Test
    public void testResourceCount() {
        _test__resourceCount_transitions0_effect_state();

    }

    private void _test__doCalculations_transitions0_effect_state() {
        _test__doCalculations_transitions0_effect_state_objectTests0_test();

    }

    private void _test__doCalculations_transitions0_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 0 failed", 0, _taskCount);

    }

    private void _transition_exprAction__doCalculations_transitions1_actions0() {

        final BinaryOperator<Double> _function = new BinaryOperator<Double>() {
            public Double apply(final Double x, final Double y) {
                return Double.valueOf((x + y));
            }
        };
        double _doCalculations = this.clerk.doCalculations(_function, 2.0, 3.5);
        boolean _assertEquals = this.operator_assertEquals(_doCalculations, 5.5);
        Assert.assertTrue("clerk.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5 failed", Boolean.valueOf(_assertEquals));

    }

    private void _test__doCalculations_transitions1_effect_state() {
        _test__doCalculations_transitions1_effect_state_objectTests0_test();

    }

    private void _test__doCalculations_transitions1_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 1 failed after clerk.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5", 1, _taskCount);

    }

    private void _transition_exprAction__doCalculations_transitions2_actions0() {

        final BinaryOperator<Double> _function = new BinaryOperator<Double>() {
            public Double apply(final Double x, final Double y) {
                return Double.valueOf((x / y));
            }
        };
        double _doCalculations = this.clerk.doCalculations(_function, 2.0, 4.0);
        boolean _assertEquals = this.operator_assertEquals(_doCalculations, 0.5);
        Assert.assertTrue("clerk.doCalculations([double x, double y | x / y ], 2.0, 4.0) ?= 0.5 failed", Boolean.valueOf(_assertEquals));

    }

    private void _test__doCalculations_transitions2_effect_state() {
        _test__doCalculations_transitions2_effect_state_objectTests0_test();

    }

    private void _test__doCalculations_transitions2_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 2 failed after clerk.doCalculations([double x, double y | x / y ], 2.0, 4.0) ?= 0.5", 2, _taskCount);

    }

    private void _test__printDocuments_transitions0_effect_state() {
        _test__printDocuments_transitions0_effect_state_objectTests0_test();

    }

    private void _test__printDocuments_transitions0_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 0 failed", 0, _taskCount);

    }

    private void _transition_exprAction__printDocuments_transitions1_actions0() {
        try {

            this.clerk.printDocument("dokument1");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("clerk.printDocument(\"dokument1\") failed: " + error.getMessage());
        }

    }

    private void _test__printDocuments_transitions1_effect_state() {
        _test__printDocuments_transitions1_effect_state_objectTests0_test();

    }

    private void _test__printDocuments_transitions1_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk);
        String _get = ((String[]) Conversions.unwrapArray(_printHistory, String.class))[0];
        Assert.assertEquals("printer.getPrintHistory(clerk).get(0) == \"dokument1\" failed after clerk.printDocument(\"dokument1\")", "dokument1", _get);

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 1 failed after clerk.printDocument(\"dokument1\")", 1, _taskCount);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk);
        int _size = _printHistory_1.size();
        Assert.assertEquals("printer.getPrintHistory(clerk).size == 1 failed after clerk.printDocument(\"dokument1\")", 1, _size);

    }

    private void _transition_exprAction__printDocuments_transitions2_actions0() {
        try {

            this.clerk.printDocument("dokument2");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("clerk.printDocument(\"dokument2\") failed: " + error.getMessage());
        }

    }

    private void _test__printDocuments_transitions2_effect_state() {
        _test__printDocuments_transitions2_effect_state_objectTests0_test();

    }

    private void _test__printDocuments_transitions2_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk);
        String _get = ((String[]) Conversions.unwrapArray(_printHistory, String.class))[1];
        Assert.assertEquals("printer.getPrintHistory(clerk).get(1) == \"dokument2\" failed after clerk.printDocument(\"dokument2\")", "dokument2", _get);

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 2 failed after clerk.printDocument(\"dokument2\")", 2, _taskCount);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk);
        int _size = _printHistory_1.size();
        Assert.assertEquals("printer.getPrintHistory(clerk).size == 2 failed after clerk.printDocument(\"dokument2\")", 2, _size);

    }

    private void _test__taskCount_transitions0_effect_state() {
        _test__taskCount_transitions0_effect_state_objectTests0_test();

    }

    private void _test__taskCount_transitions0_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 0 failed", 0, _taskCount);

    }

    private void _transition_exprAction__taskCount_transitions1_actions0() {
        try {

            this.clerk.printDocument("dokument1");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("clerk.printDocument(\"dokument1\") failed: " + error.getMessage());
        }

    }

    private void _test__taskCount_transitions1_effect_state() {
        _test__taskCount_transitions1_effect_state_objectTests0_test();

    }

    private void _test__taskCount_transitions1_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 1 failed after clerk.printDocument(\"dokument1\")", 1, _taskCount);

    }

    private void _transition_exprAction__taskCount_transitions2_actions0() {
        try {

            final BinaryOperator<Double> _function = new BinaryOperator<Double>() {
                public Double apply(final Double x, final Double y) {
                    return Double.valueOf((x + y));
                }
            };
            this.clerk.doCalculations(_function, 2.0, 3.5);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("clerk.doCalculations([double x, double y | x + y ], 2.0, 3.5) failed: " + error.getMessage());
        }

    }

    private void _test__taskCount_transitions2_effect_state() {
        _test__taskCount_transitions2_effect_state_objectTests0_test();

    }

    private void _test__taskCount_transitions2_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 2 failed after clerk.doCalculations([double x, double y | x + y ], 2.0, 3.5)", 2, _taskCount);

    }

    private void _test__resourceCount_transitions0_effect_state() {
        _test__resourceCount_transitions0_effect_state_objectTests0_test();

    }

    private void _test__resourceCount_transitions0_effect_state_objectTests0_test() {

        int _resourceCount = this.clerk.getResourceCount();
        Assert.assertEquals("clerk.resourceCount == 1 failed", 1, _resourceCount);

    }
}
