package org.tanberg.oving8;

import org.eclipse.xtext.xbase.lib.Conversions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tanberg.oving8.office.Clerk;
import org.tanberg.oving8.office.Printer;

import java.util.Collection;

public class PrinterTest {

    private Printer printer;

    private Printer _init_printer() {
        return new Printer();
    }

    private Clerk clerk1;

    private Clerk _init_clerk1() {
        return new Clerk(this.printer);
    }

    private Clerk clerk2;

    private Clerk _init_clerk2() {
        return new Clerk(this.printer);
    }

    @Before
    public void setUp() {
        printer = _init_printer();
        clerk1 = _init_clerk1();
        clerk2 = _init_clerk2();

    }

    @Test
    public void testPrintSingleClerk() {
        _test__printSingleClerk_transitions0_effect_state();
        _transition_exprAction__printSingleClerk_transitions1_actions0();
        _test__printSingleClerk_transitions1_effect_state();
        _transition_exprAction__printSingleClerk_transitions2_actions0();
        _test__printSingleClerk_transitions2_effect_state();

    }

    @Test
    public void testPrintMulipleClerks() {
        _test__printMulipleClerks_transitions0_effect_state();
        _transition_exprAction__printMulipleClerks_transitions1_actions0();
        _test__printMulipleClerks_transitions1_effect_state();
        _transition_exprAction__printMulipleClerks_transitions2_actions0();
        _test__printMulipleClerks_transitions2_effect_state();

    }

    @Test
    public void testPrintHistoryModification() {
        _transition_exprAction__printHistoryModification_transitions0_actions0();
        _transition_exprAction__printHistoryModification_transitions0_actions1();
        _test__printHistoryModification_transitions0_effect_state();
        _transition_exprAction__printHistoryModification_transitions1_actions0();
        _test__printHistoryModification_transitions1_effect_state();

    }

    private void _test__printSingleClerk_transitions0_effect_state() {
        _test__printSingleClerk_transitions0_effect_state_objectTests0_test();

    }

    private void _test__printSingleClerk_transitions0_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 0 failed", 0, _size);

    }

    private void _transition_exprAction__printSingleClerk_transitions1_actions0() {
        try {

            this.printer.printDocument("dokument1", this.clerk1);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("printer.printDocument(\"dokument1\", clerk1) failed: " + error.getMessage());
        }

    }

    private void _test__printSingleClerk_transitions1_effect_state() {
        _test__printSingleClerk_transitions1_effect_state_objectTests0_test();

    }

    private void _test__printSingleClerk_transitions1_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 1 failed after printer.printDocument(\"dokument1\", clerk1)", 1, _size);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk1);
        String _get = ((String[]) Conversions.unwrapArray(_printHistory_1, String.class))[0];
        Assert.assertEquals("printer.getPrintHistory(clerk1).get(0) == \"dokument1\" failed after printer.printDocument(\"dokument1\", clerk1)", "dokument1", _get);

    }

    private void _transition_exprAction__printSingleClerk_transitions2_actions0() {
        try {

            this.printer.printDocument("dokument2", this.clerk1);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("printer.printDocument(\"dokument2\", clerk1) failed: " + error.getMessage());
        }

    }

    private void _test__printSingleClerk_transitions2_effect_state() {
        _test__printSingleClerk_transitions2_effect_state_objectTests0_test();

    }

    private void _test__printSingleClerk_transitions2_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 2 failed after printer.printDocument(\"dokument2\", clerk1)", 2, _size);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk1);
        String _get = ((String[]) Conversions.unwrapArray(_printHistory_1, String.class))[1];
        Assert.assertEquals("printer.getPrintHistory(clerk1).get(1) == \"dokument2\" failed after printer.printDocument(\"dokument2\", clerk1)", "dokument2", _get);

    }

    private void _test__printMulipleClerks_transitions0_effect_state() {
        _test__printMulipleClerks_transitions0_effect_state_objectTests0_test();

    }

    private void _test__printMulipleClerks_transitions0_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 0 failed", 0, _size);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk2);
        int _size_1 = _printHistory_1.size();
        Assert.assertEquals("printer.getPrintHistory(clerk2).size == 0 failed", 0, _size_1);

    }

    private void _transition_exprAction__printMulipleClerks_transitions1_actions0() {
        try {

            this.printer.printDocument("dokument1", this.clerk1);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("printer.printDocument(\"dokument1\", clerk1) failed: " + error.getMessage());
        }

    }

    private void _test__printMulipleClerks_transitions1_effect_state() {
        _test__printMulipleClerks_transitions1_effect_state_objectTests0_test();

    }

    private void _test__printMulipleClerks_transitions1_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 1 failed after printer.printDocument(\"dokument1\", clerk1)", 1, _size);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk2);
        int _size_1 = _printHistory_1.size();
        Assert.assertEquals("printer.getPrintHistory(clerk2).size == 0 failed after printer.printDocument(\"dokument1\", clerk1)", 0, _size_1);

    }

    private void _transition_exprAction__printMulipleClerks_transitions2_actions0() {
        try {

            this.printer.printDocument("dokument2", this.clerk2);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("printer.printDocument(\"dokument2\", clerk2) failed: " + error.getMessage());
        }

    }

    private void _test__printMulipleClerks_transitions2_effect_state() {
        _test__printMulipleClerks_transitions2_effect_state_objectTests0_test();

    }

    private void _test__printMulipleClerks_transitions2_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 1 failed after printer.printDocument(\"dokument2\", clerk2)", 1, _size);

        Collection<String> _printHistory_1 = this.printer.getPrintHistory(this.clerk2);
        int _size_1 = _printHistory_1.size();
        Assert.assertEquals("printer.getPrintHistory(clerk2).size == 1 failed after printer.printDocument(\"dokument2\", clerk2)", 1, _size_1);

    }

    private void _transition_exprAction__printHistoryModification_transitions0_actions0() {
        try {

            this.printer.printDocument("dokument1", this.clerk1);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("printer.printDocument(\"dokument1\", clerk1) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__printHistoryModification_transitions0_actions1() {
        try {

            this.printer.printDocument("dokument2", this.clerk1);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("printer.printDocument(\"dokument2\", clerk1) failed: " + error.getMessage());
        }

    }

    private void _test__printHistoryModification_transitions0_effect_state() {
        _test__printHistoryModification_transitions0_effect_state_objectTests0_test();

    }

    private void _test__printHistoryModification_transitions0_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 2 failed after printer.printDocument(\"dokument1\", clerk1) ,printer.printDocument(\"dokument2\", clerk1)", 2, _size);

    }

    private void _transition_exprAction__printHistoryModification_transitions1_actions0() {
        try {

            Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
            _printHistory.remove(Integer.valueOf(0));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("printer.getPrintHistory(clerk1).remove(0) failed: " + error.getMessage());
        }

    }

    private void _test__printHistoryModification_transitions1_effect_state() {
        _test__printHistoryModification_transitions1_effect_state_objectTests0_test();

    }

    private void _test__printHistoryModification_transitions1_effect_state_objectTests0_test() {

        Collection<String> _printHistory = this.printer.getPrintHistory(this.clerk1);
        int _size = _printHistory.size();
        Assert.assertEquals("printer.getPrintHistory(clerk1).size == 2 failed after printer.getPrintHistory(clerk1).remove(0)", 2, _size);

    }
}

