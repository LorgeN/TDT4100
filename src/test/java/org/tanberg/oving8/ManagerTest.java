package org.tanberg.oving8;

import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class ManagerTest {

    private Printer printer;

    private Printer _init_printer() {
        return new Printer();
    }

    private Clerk clerk;

    private Clerk _init_clerk() {
        return new Clerk(this.printer);
    }

    private Clerk secondClerk;

    private Clerk _init_secondClerk() {
        return new Clerk(this.printer);
    }

    private Manager manager;

    private Manager _init_manager() {
        List<Employee> _asList = Arrays.asList(this.clerk);
        return new Manager(_asList);
    }

    @Before
    public void setUp() {
        printer = _init_printer();
        clerk = _init_clerk();
        secondClerk = _init_secondClerk();
        manager = _init_manager();

    }

    private boolean operator_assertEquals(final double first, final double second) {
        TestCase.assertEquals(first, second, 0.000001d);
        return true;
    }

    @Test
    public void testNoEmployeesConstructor() {
        try {
            _transition_exprAction__noEmployeesConstructor_transitions0_actions0();
            Assert.fail("IllegalArgumentException should be thrown after new Manager(new ArrayList<Employee>)");
        } catch (Exception e) {
            Assert.assertTrue("IllegalArgumentException should be thrown after new Manager(new ArrayList<Employee>)", e instanceof IllegalArgumentException);
        }

    }

    @Test
    public void testResourceCount() {
        _transition_exprAction__resourceCount_transitions0_actions0();
        _test__resourceCount_transitions0_effect_state();

    }

    @Test
    public void testMiddleManagementResourceCounts() {
        Manager topManager = _init__middleManagementResourceCounts_topManager();
        _transition_exprAction__middleManagementResourceCounts_transitions0_actions0(topManager);
        _test__middleManagementResourceCounts_transitions0_effect_state(topManager);

    }

    @Test
    public void testDoCalculations() {
        _test__doCalculations_transitions0_effect_state();
        _transition_exprAction__doCalculations_transitions1_actions0();
        _test__doCalculations_transitions1_effect_state();

    }

    @Test
    public void testPrintDocuments() {
        _transition_exprAction__printDocuments_transitions0_actions0();
        _test__printDocuments_transitions0_effect_state();

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
    public void testSeveralClerks() {
        Manager multiManager = _init__severalClerks_multiManager();
        _test__severalClerks_transitions0_effect_state(multiManager);
        _transition_exprAction__severalClerks_transitions1_actions0(multiManager);
        _test__severalClerks_transitions1_effect_state(multiManager);
        _transition_exprAction__severalClerks_transitions2_actions0(multiManager);
        _test__severalClerks_transitions2_effect_state(multiManager);

    }

    private void _transition_exprAction__noEmployeesConstructor_transitions0_actions0() {
        try {

            ArrayList<Employee> _arrayList = new ArrayList<Employee>();
            new Manager(_arrayList);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("new Manager(new ArrayList<Employee>) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__resourceCount_transitions0_actions0() {

        int _resourceCount = this.manager.getResourceCount();
        Assert.assertEquals("manager.resourceCount == 2 failed", 2, _resourceCount);

    }

    private void _test__resourceCount_transitions0_effect_state() {
        _test__resourceCount_transitions0_effect_state_objectTests0_test();

    }

    private void _test__resourceCount_transitions0_effect_state_objectTests0_test() {

    }

    private Manager _init__middleManagementResourceCounts_topManager() {
        List<Employee> _asList = Arrays.<Employee>asList(this.manager);
        Manager _manager = new Manager(_asList);
        return _manager;
    }

    private void _transition_exprAction__middleManagementResourceCounts_transitions0_actions0(final Manager topManager) {

        int _resourceCount = topManager.getResourceCount();
        Assert.assertEquals("topManager.resourceCount == 3 failed", 3, _resourceCount);

    }

    private void _test__middleManagementResourceCounts_transitions0_effect_state(final Manager topManager) {
        _test__middleManagementResourceCounts_transitions0_effect_state_objectTests0_test(topManager);

    }

    private void _test__middleManagementResourceCounts_transitions0_effect_state_objectTests0_test(final Manager topManager) {

    }

    private void _test__doCalculations_transitions0_effect_state() {
        _test__doCalculations_transitions0_effect_state_objectTests0_test();

    }

    private void _test__doCalculations_transitions0_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 0 failed", 0, _taskCount);

        int _taskCount_1 = this.manager.getTaskCount();
        Assert.assertEquals("manager.taskCount == 0 failed", 0, _taskCount_1);

    }

    private void _transition_exprAction__doCalculations_transitions1_actions0() {

        final BinaryOperator<Double> _function = new BinaryOperator<Double>() {
            public Double apply(final Double x, final Double y) {
                return Double.valueOf((x + y));
            }
        };
        double _doCalculations = this.manager.doCalculations(_function, 2.0, 3.5);
        boolean _assertEquals = this.operator_assertEquals(_doCalculations, 5.5);
        Assert.assertTrue("manager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5 failed", Boolean.valueOf(_assertEquals));

    }

    private void _test__doCalculations_transitions1_effect_state() {
        _test__doCalculations_transitions1_effect_state_objectTests0_test();

    }

    private void _test__doCalculations_transitions1_effect_state_objectTests0_test() {

        int _taskCount = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 1 failed after manager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5", 1, _taskCount);

        int _taskCount_1 = this.manager.getTaskCount();
        Assert.assertEquals("manager.taskCount == 1 failed after manager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5", 1, _taskCount_1);

    }

    private void _transition_exprAction__printDocuments_transitions0_actions0() {
        try {

            this.manager.printDocument("dokument1");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("manager.printDocument(\"dokument1\") failed: " + error.getMessage());
        }

    }

    private void _test__printDocuments_transitions0_effect_state() {
        _test__printDocuments_transitions0_effect_state_objectTests0_test();

    }

    private void _test__printDocuments_transitions0_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk);
        String _get = ((String[]) Conversions.unwrapArray(_printHistory, String.class))[0];
        Assert.assertEquals("printer.getPrintHistory(clerk).get(0) == \"dokument1\" failed after manager.printDocument(\"dokument1\")", "dokument1", _get);

        int _taskCount = this.manager.getTaskCount();
        Assert.assertEquals("manager.taskCount == 1 failed after manager.printDocument(\"dokument1\")", 1, _taskCount);

        int _taskCount_1 = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 1 failed after manager.printDocument(\"dokument1\")", 1, _taskCount_1);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk);
        int _size = _printHistory_1.size();
        Assert.assertEquals("printer.getPrintHistory(clerk).size == 1 failed after manager.printDocument(\"dokument1\")", 1, _size);

    }

    private void _test__taskCount_transitions0_effect_state() {
        _test__taskCount_transitions0_effect_state_objectTests0_test();

    }

    private void _test__taskCount_transitions0_effect_state_objectTests0_test() {

        int _taskCount = this.manager.getTaskCount();
        Assert.assertEquals("manager.taskCount == 0 failed", 0, _taskCount);

        int _taskCount_1 = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 0 failed", 0, _taskCount_1);

    }

    private void _transition_exprAction__taskCount_transitions1_actions0() {
        try {

            this.manager.printDocument("dokument");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("manager.printDocument(\"dokument\") failed: " + error.getMessage());
        }

    }

    private void _test__taskCount_transitions1_effect_state() {
        _test__taskCount_transitions1_effect_state_objectTests0_test();

    }

    private void _test__taskCount_transitions1_effect_state_objectTests0_test() {

        int _taskCount = this.manager.getTaskCount();
        Assert.assertEquals("manager.taskCount == 1 failed after manager.printDocument(\"dokument\")", 1, _taskCount);

        int _taskCount_1 = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 1 failed after manager.printDocument(\"dokument\")", 1, _taskCount_1);

    }

    private void _transition_exprAction__taskCount_transitions2_actions0() {

        final BinaryOperator<Double> _function = new BinaryOperator<Double>() {
            public Double apply(final Double x, final Double y) {
                return Double.valueOf((x + y));
            }
        };
        double _doCalculations = this.manager.doCalculations(_function, 2.0, 3.5);
        boolean _assertEquals = this.operator_assertEquals(_doCalculations, 5.5);
        Assert.assertTrue("manager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5 failed", Boolean.valueOf(_assertEquals));

    }

    private void _test__taskCount_transitions2_effect_state() {
        _test__taskCount_transitions2_effect_state_objectTests0_test();

    }

    private void _test__taskCount_transitions2_effect_state_objectTests0_test() {

        int _taskCount = this.manager.getTaskCount();
        Assert.assertEquals("manager.taskCount == 2 failed after manager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5", 2, _taskCount);

        int _taskCount_1 = this.clerk.getTaskCount();
        Assert.assertEquals("clerk.taskCount == 2 failed after manager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5", 2, _taskCount_1);

    }

    private Manager _init__severalClerks_multiManager() {
        List<Employee> _asList = Arrays.<Employee>asList(this.clerk, this.secondClerk);
        Manager _manager = new Manager(_asList);
        return _manager;
    }

    private void _test__severalClerks_transitions0_effect_state(final Manager multiManager) {
        _test__severalClerks_transitions0_effect_state_objectTests0_test(multiManager);

    }

    private void _test__severalClerks_transitions0_effect_state_objectTests0_test(final Manager multiManager) {

        int _resourceCount = multiManager.getResourceCount();
        Assert.assertEquals("multiManager.resourceCount == 3 failed", 3, _resourceCount);

        int _resourceCount_1 = this.clerk.getResourceCount();
        Assert.assertEquals("clerk.resourceCount == 1 failed", 1, _resourceCount_1);

        int _resourceCount_2 = this.secondClerk.getResourceCount();
        Assert.assertEquals("secondClerk.resourceCount == 1 failed", 1, _resourceCount_2);

    }

    private void _transition_exprAction__severalClerks_transitions1_actions0(final Manager multiManager) {
        try {

            multiManager.printDocument("dokument");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("multiManager.printDocument(\"dokument\") failed: " + error.getMessage());
        }

    }

    private void _test__severalClerks_transitions1_effect_state(final Manager multiManager) {
        _test__severalClerks_transitions1_effect_state_objectTests0_test(multiManager);

    }

    private void _test__severalClerks_transitions1_effect_state_objectTests0_test(final Manager multiManager) {

        int _taskCount = multiManager.getTaskCount();
        Assert.assertEquals("multiManager.taskCount == 1 failed after multiManager.printDocument(\"dokument\")", 1, _taskCount);

        boolean _and = false;
        boolean _or = false;
        int _taskCount_1 = this.clerk.getTaskCount();
        boolean _equals = (_taskCount_1 == 1);
        if (_equals) {
            _or = true;
        } else {
            int _taskCount_2 = this.secondClerk.getTaskCount();
            boolean _equals_1 = (_taskCount_2 == 1);
            _or = _equals_1;
        }
        if (!_or) {
            _and = false;
        } else {
            boolean _or_1 = false;
            int _taskCount_3 = this.clerk.getTaskCount();
            boolean _equals_2 = (_taskCount_3 == 0);
            if (_equals_2) {
                _or_1 = true;
            } else {
                int _taskCount_4 = this.secondClerk.getTaskCount();
                boolean _equals_3 = (_taskCount_4 == 0);
                _or_1 = _equals_3;
            }
            _and = _or_1;
        }
        Assert.assertTrue("(clerk.taskCount == 1 || secondClerk.taskCount == 1) && (clerk.taskCount == 0 || secondClerk.taskCount == 0) failed after multiManager.printDocument(\"dokument\")", _and);

    }

    private void _transition_exprAction__severalClerks_transitions2_actions0(final Manager multiManager) {

        final BinaryOperator<Double> _function = new BinaryOperator<Double>() {
            public Double apply(final Double x, final Double y) {
                return Double.valueOf((x + y));
            }
        };
        double _doCalculations = multiManager.doCalculations(_function, 2.0, 3.5);
        boolean _assertEquals = this.operator_assertEquals(_doCalculations, 5.5);
        Assert.assertTrue("multiManager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5 failed", Boolean.valueOf(_assertEquals));

    }

    private void _test__severalClerks_transitions2_effect_state(final Manager multiManager) {
        _test__severalClerks_transitions2_effect_state_objectTests0_test(multiManager);

    }

    private void _test__severalClerks_transitions2_effect_state_objectTests0_test(final Manager multiManager) {

        int _taskCount = multiManager.getTaskCount();
        Assert.assertEquals("multiManager.taskCount == 2 failed after multiManager.doCalculations([double x, double y | x + y ], 2.0, 3.5) ?= 5.5", 2, _taskCount);

    }
}

