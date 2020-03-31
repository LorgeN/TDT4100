package org.tanberg.oving9;


import junit.framework.TestCase;
import org.junit.Assert;

public class ObservableListTest extends TestCase {

    private ObservableList observableList;

    private ObservableList _init_observableList() {
        return new ObservableList() {
            @Override
            public boolean acceptsElement(final Object element) {
                return (element instanceof Integer);
            }
        };
    }

    private int pos1;

    private int _init_pos1() {
        return (-1);
    }

    private int pos2;

    private int _init_pos2() {
        return (-1);
    }

    @Override
    protected void setUp() {
        this.observableList = this._init_observableList();
        this.pos1 = this._init_pos1();
        this.pos2 = this._init_pos2();

    }

    private void addElement(final int pos, final int element) {
        this.pos1 = pos;
        this.observableList.addElement(pos, element);
        TestCase.assertEquals(this.pos1, this.pos2);
    }

    private void operator_assertEquals(final ObservableList observableList, final int[] elements) {
        int _length = elements.length;
        int _size = observableList.size();
        Assert.assertEquals(_length, _size);

        int i = 0;
        for (final int element : elements) {
            Object _element = observableList.getElement(i);
            Assert.assertEquals(element, _element);
            i++;
        }
    }

    public void testConstructor() {
        this._test__constructor_transitions0_effects0_state();

    }

    public void testAcceptsElement() {
        this._test__acceptsElement_transitions0_effects0_state();
        try {
            this._transition_exprAction__acceptsElement_transitions1_actions0();
            fail("IllegalArgumentException should be thrown after observableList.addElement(\"5\")");
        } catch (Exception e) {
            assertTrue("IllegalArgumentException should be thrown after observableList.addElement(\"5\")", e instanceof IllegalArgumentException);
        }

    }

    public void testAddElement() {
        this._transition_exprAction__addElement_transitions0_actions0();
        this._test__addElement_transitions0_effects0_state();
        this._transition_exprAction__addElement_transitions1_actions0();
        this._test__addElement_transitions1_effects0_state();
        this._transition_exprAction__addElement_transitions2_actions0();
        this._test__addElement_transitions2_effects0_state();

    }

    public void testListListener() {
        this._transition_exprAction__listListener_transitions0_actions0();
        this._transition_exprAction__listListener_transitions0_actions1();
        this._test__listListener_transitions0_effects0_state();
        this._transition_exprAction__listListener_transitions1_actions0();
        this._test__listListener_transitions1_effects0_state();
        this._transition_exprAction__listListener_transitions2_actions0();
        this._test__listListener_transitions2_effects0_state();

    }

    private void _test__constructor_transitions0_effects0_state() {
        this._test__constructor_transitions0_effects0_state_objectTests0_test(this.observableList);

    }

    private void _test__constructor_transitions0_effects0_state_objectTests0_test(final ObservableList it) {

        int _size = it.size();
        assertEquals("size() == 0 failed", 0, _size);

    }

    private void _test__acceptsElement_transitions0_effects0_state() {
        this._test__acceptsElement_transitions0_effects0_state_objectTests0_test(this.observableList);

    }

    private void _test__acceptsElement_transitions0_effects0_state_objectTests0_test(final ObservableList it) {

        boolean _acceptsElement = it.acceptsElement(5);
        assertTrue("acceptsElement(5) failed", _acceptsElement);

        boolean _acceptsElement_1 = it.acceptsElement("5");
        assertTrue("! acceptsElement(\"5\") failed", (!_acceptsElement_1));

    }

    private void _transition_exprAction__acceptsElement_transitions1_actions0() {
        try {

            this.observableList.addElement("5");
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList.addElement(\"5\") failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElement_transitions0_actions0() {
        try {

            this.observableList.addElement(5);
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList.addElement(5) failed: " + error.getMessage());
        }

    }

    private void _test__addElement_transitions0_effects0_state() {
        this._test__addElement_transitions0_effects0_state_objectTests0_test();

    }

    private void _test__addElement_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.observableList, new int[]{5});
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList ?= #[5] failed after observableList.addElement(5): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElement_transitions1_actions0() {
        try {

            this.observableList.addElement(6);
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList.addElement(6) failed: " + error.getMessage());
        }

    }

    private void _test__addElement_transitions1_effects0_state() {
        this._test__addElement_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__addElement_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.observableList, new int[]{5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList ?= #[5, 6] failed after observableList.addElement(6): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElement_transitions2_actions0() {
        try {

            this.observableList.addElement(0, Integer.valueOf(2));
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList.addElement(0, 2) failed: " + error.getMessage());
        }

    }

    private void _test__addElement_transitions2_effects0_state() {
        this._test__addElement_transitions2_effects0_state_objectTests0_test();

    }

    private void _test__addElement_transitions2_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.observableList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList ?= #[2, 5, 6] failed after observableList.addElement(0, 2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListener_transitions0_actions0() {
        try {
            this.observableList.subscribe(((list, value, added) -> this.pos2 = list.lastIndexOf(value)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList.addListChangeListener([list, pos | pos2 = pos]) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListener_transitions0_actions1() {
        try {

            this.addElement(0, 5);
        } catch (junit.framework.AssertionFailedError error) {
            fail("addElement(0, 5) failed: " + error.getMessage());
        }

    }

    private void _test__listListener_transitions0_effects0_state() {
        this._test__listListener_transitions0_effects0_state_objectTests0_test();
    }

    private void _test__listListener_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.observableList, new int[]{5});
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList ?= #[5] failed after observableList.addListChangeListener([list, pos | pos2 = pos]) ,addElement(0, 5): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListener_transitions1_actions0() {
        try {

            this.addElement(1, 6);
        } catch (junit.framework.AssertionFailedError error) {
            fail("addElement(1, 6) failed: " + error.getMessage());
        }

    }

    private void _test__listListener_transitions1_effects0_state() {
        this._test__listListener_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__listListener_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.observableList, new int[]{5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList ?= #[5, 6] failed after addElement(1, 6): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListener_transitions2_actions0() {
        try {

            this.addElement(0, 2);
        } catch (junit.framework.AssertionFailedError error) {
            fail("addElement(0, 2) failed: " + error.getMessage());
        }

    }

    private void _test__listListener_transitions2_effects0_state() {
        this._test__listListener_transitions2_effects0_state_objectTests0_test();

    }

    private void _test__listListener_transitions2_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.observableList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            fail("observableList ?= #[2, 5, 6] failed after addElement(0, 2): " + error.getMessage());
        }

    }
}

