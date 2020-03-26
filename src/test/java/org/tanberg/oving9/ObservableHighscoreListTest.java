package org.tanberg.oving9;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObservableHighscoreListTest {

    private HighscoreList highscoreList;

    private HighscoreList _init_highscoreList() {
        return new HighscoreList(3);
    }

    private int pos1;

    private int _init_pos1() {
        return (-1);
    }

    private int pos2;

    private int _init_pos2() {
        return (-1);
    }

    @Before
    public void setUp() {
        this.highscoreList = this._init_highscoreList();
        this.pos1 = this._init_pos1();
        this.pos2 = this._init_pos2();

    }

    private void addResult(final int pos, final int element) {
        this.pos1 = pos;
        this.highscoreList.addResult(element);
        TestCase.assertEquals(this.pos1, this.pos2);
    }

    private void operator_assertEquals(final HighscoreList highscoreList, final int[] elements) {
        int _length = elements.length;
        int _size = highscoreList.size();

        Assert.assertEquals(_length, _size);

        int i = 0;
        for (final int element : elements) {
            {
                Object _element = highscoreList.getElement(i);
                Assert.assertEquals(element, _element);
                i++;
            }
        }
    }

    @Test
    public void testConstructor() {
        this._test__constructor_transitions0_effects0_state();

    }

    @Test
    public void testAddElementSimple() {
        this._transition_exprAction__addElementSimple_transitions0_actions0();
        this._test__addElementSimple_transitions0_effects0_state();
        this._transition_exprAction__addElementSimple_transitions1_actions0();
        this._test__addElementSimple_transitions1_effects0_state();
        this._transition_exprAction__addElementSimple_transitions2_actions0();
        this._test__addElementSimple_transitions2_effects0_state();

    }

    @Test
    public void testAddElementMoreThanMax() {
        this._transition_exprAction__addElementMoreThanMax_transitions0_actions0();
        this._transition_exprAction__addElementMoreThanMax_transitions0_actions1();
        this._transition_exprAction__addElementMoreThanMax_transitions0_actions2();
        this._test__addElementMoreThanMax_transitions0_effects0_state();
        this._transition_exprAction__addElementMoreThanMax_transitions1_actions0();
        this._test__addElementMoreThanMax_transitions1_effects0_state();
        this._transition_exprAction__addElementMoreThanMax_transitions2_actions0();
        this._test__addElementMoreThanMax_transitions2_effects0_state();

    }

    @Test
    public void testAddElementDuplicate() {
        this._transition_exprAction__addElementDuplicate_transitions0_actions0();
        this._transition_exprAction__addElementDuplicate_transitions0_actions1();
        this._transition_exprAction__addElementDuplicate_transitions0_actions2();
        this._test__addElementDuplicate_transitions0_effects0_state();
        this._transition_exprAction__addElementDuplicate_transitions1_actions0();
        this._test__addElementDuplicate_transitions1_effects0_state();

    }

    @Test
    public void testListListenerSimple() {
        this._transition_exprAction__listListenerSimple_transitions0_actions0();
        this._transition_exprAction__listListenerSimple_transitions0_actions1();
        this._test__listListenerSimple_transitions0_effects0_state();
        this._transition_exprAction__listListenerSimple_transitions1_actions0();
        this._test__listListenerSimple_transitions1_effects0_state();
        this._transition_exprAction__listListenerSimple_transitions2_actions0();
        this._test__listListenerSimple_transitions2_effects0_state();

    }

    @Test
    public void testListListenerMoreThanMax() {
        this._transition_exprAction__listListenerMoreThanMax_transitions0_actions0();
        this._transition_exprAction__listListenerMoreThanMax_transitions0_actions1();
        this._transition_exprAction__listListenerMoreThanMax_transitions0_actions2();
        this._transition_exprAction__listListenerMoreThanMax_transitions0_actions3();
        this._test__listListenerMoreThanMax_transitions0_effects0_state();
        this._transition_exprAction__listListenerMoreThanMax_transitions1_actions0();
        this._test__listListenerMoreThanMax_transitions1_effects0_state();
        this._transition_exprAction__listListenerMoreThanMax_transitions2_actions0();
        this._transition_exprAction__listListenerMoreThanMax_transitions2_actions1();
        this._test__listListenerMoreThanMax_transitions2_effects0_state();

    }

    @Test
    public void testListListenerDuplicate() {
        this._transition_exprAction__listListenerDuplicate_transitions0_actions0();
        this._transition_exprAction__listListenerDuplicate_transitions0_actions1();
        this._transition_exprAction__listListenerDuplicate_transitions0_actions2();
        this._transition_exprAction__listListenerDuplicate_transitions0_actions3();
        this._test__listListenerDuplicate_transitions0_effects0_state();
        this._transition_exprAction__listListenerDuplicate_transitions1_actions0();
        this._test__listListenerDuplicate_transitions1_effects0_state();

    }

    private void _test__constructor_transitions0_effects0_state() {
        this._test__constructor_transitions0_effects0_state_objectTests0_test(this.highscoreList);

    }

    private void _test__constructor_transitions0_effects0_state_objectTests0_test(final HighscoreList it) {

        int _size = it.size();
        Assert.assertEquals("size() == 0 failed", 0, _size);

    }

    private void _transition_exprAction__addElementSimple_transitions0_actions0() {
        try {

            this.highscoreList.addResult(Integer.valueOf(5));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(5) failed: " + error.getMessage());
        }

    }

    private void _test__addElementSimple_transitions0_effects0_state() {
        this._test__addElementSimple_transitions0_effects0_state_objectTests0_test();

    }

    private void _test__addElementSimple_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[5] failed after highscoreList.addResult(5): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementSimple_transitions1_actions0() {
        try {

            this.highscoreList.addResult(Integer.valueOf(6));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(6) failed: " + error.getMessage());
        }

    }

    private void _test__addElementSimple_transitions1_effects0_state() {
        this._test__addElementSimple_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__addElementSimple_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[5, 6] failed after highscoreList.addResult(6): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementSimple_transitions2_actions0() {
        try {

            this.highscoreList.addResult(2);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(2) failed: " + error.getMessage());
        }

    }

    private void _test__addElementSimple_transitions2_effects0_state() {
        this._test__addElementSimple_transitions2_effects0_state_objectTests0_test();

    }

    private void _test__addElementSimple_transitions2_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addResult(2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementMoreThanMax_transitions0_actions0() {
        try {

            this.highscoreList.addResult(Integer.valueOf(5));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(5) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementMoreThanMax_transitions0_actions1() {
        try {

            this.highscoreList.addResult(Integer.valueOf(6));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(6) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementMoreThanMax_transitions0_actions2() {
        try {

            this.highscoreList.addResult(Integer.valueOf(2));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(2) failed: " + error.getMessage());
        }

    }

    private void _test__addElementMoreThanMax_transitions0_effects0_state() {
        this._test__addElementMoreThanMax_transitions0_effects0_state_objectTests0_test();

    }

    private void _test__addElementMoreThanMax_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementMoreThanMax_transitions1_actions0() {
        try {

            this.highscoreList.addResult(Integer.valueOf(3));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(3) failed: " + error.getMessage());
        }

    }

    private void _test__addElementMoreThanMax_transitions1_effects0_state() {
        this._test__addElementMoreThanMax_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__addElementMoreThanMax_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 3, 5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 3, 5] failed after highscoreList.addResult(3): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementMoreThanMax_transitions2_actions0() {
        try {

            this.highscoreList.addResult(Integer.valueOf(7));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(7) failed: " + error.getMessage());
        }

    }

    private void _test__addElementMoreThanMax_transitions2_effects0_state() {
        this._test__addElementMoreThanMax_transitions2_effects0_state_objectTests0_test();

    }

    private void _test__addElementMoreThanMax_transitions2_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 3, 5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 3, 5] failed after highscoreList.addResult(7): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementDuplicate_transitions0_actions0() {
        try {

            this.highscoreList.addResult(Integer.valueOf(5));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(5) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementDuplicate_transitions0_actions1() {
        try {

            this.highscoreList.addResult(Integer.valueOf(6));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(6) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementDuplicate_transitions0_actions2() {
        try {

            this.highscoreList.addResult(Integer.valueOf(2));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(2) failed: " + error.getMessage());
        }

    }

    private void _test__addElementDuplicate_transitions0_effects0_state() {
        this._test__addElementDuplicate_transitions0_effects0_state_objectTests0_test();

    }

    private void _test__addElementDuplicate_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__addElementDuplicate_transitions1_actions0() {
        try {

            this.highscoreList.addResult(Integer.valueOf(2));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(2) failed: " + error.getMessage());
        }

    }

    private void _test__addElementDuplicate_transitions1_effects0_state() {
        this._test__addElementDuplicate_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__addElementDuplicate_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 2, 5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 2, 5] failed after highscoreList.addResult(2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerSimple_transitions0_actions0() {
        try {

            final HighscoreChangeListener _function = (list, pos) -> this.pos2 = pos;
            this.highscoreList.addObservableListListener(_function);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addObservableListListener([list, pos | pos2 = pos]) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerSimple_transitions0_actions1() {
        try {

            this.addResult(0, 5);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("addResult(0, 5) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerSimple_transitions0_effects0_state() {
        this._test__listListenerSimple_transitions0_effects0_state_objectTests0_test();

    }

    private void _test__listListenerSimple_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[5] failed after highscoreList.addObservableListListener([list, pos | pos2 = pos]) ,addResult(0, 5): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerSimple_transitions1_actions0() {
        try {

            this.addResult(1, 6);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("addResult(1, 6) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerSimple_transitions1_effects0_state() {
        this._test__listListenerSimple_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__listListenerSimple_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[5, 6] failed after addResult(1, 6): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerSimple_transitions2_actions0() {
        try {

            this.addResult(0, 2);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("addResult(0, 2) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerSimple_transitions2_effects0_state() {
        this._test__listListenerSimple_transitions2_effects0_state_objectTests0_test();

    }

    private void _test__listListenerSimple_transitions2_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 5, 6] failed after addResult(0, 2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions0() {
        try {

            final HighscoreChangeListener _function = (list, pos) -> this.pos2 = pos;
            this.highscoreList.addObservableListListener(_function);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addObservableListListener([list, pos | pos2 = pos]) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions1() {
        try {

            this.highscoreList.addResult(5);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(5) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions2() {
        try {

            this.highscoreList.addResult(6);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(6) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions3() {
        try {

            this.highscoreList.addResult(2);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(2) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerMoreThanMax_transitions0_effects0_state() {
        this._test__listListenerMoreThanMax_transitions0_effects0_state_objectTests0_test();

    }

    private void _test__listListenerMoreThanMax_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addObservableListListener([list, pos | pos2 = pos]) ,highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerMoreThanMax_transitions1_actions0() {
        try {

            this.addResult(1, 3);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("addResult(1, 3) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerMoreThanMax_transitions1_effects0_state() {
        this._test__listListenerMoreThanMax_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__listListenerMoreThanMax_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 3, 5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 3, 5] failed after addResult(1, 3): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerMoreThanMax_transitions2_actions0() {
        try {

            this.pos2 = (-1);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("pos2 = -1 failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerMoreThanMax_transitions2_actions1() {
        try {

            this.addResult((-1), 7);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("addResult(-1, 7) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerMoreThanMax_transitions2_effects0_state() {
        this._test__listListenerMoreThanMax_transitions2_effects0_state_objectTests0_test();

    }

    private void _test__listListenerMoreThanMax_transitions2_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(this.highscoreList, new int[]{2, 3, 5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 3, 5] failed after pos2 = -1 ,addResult(-1, 7): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerDuplicate_transitions0_actions0() {
        try {

            final HighscoreChangeListener _function = (list, pos) -> this.pos2 = pos;
            this.highscoreList.addObservableListListener(_function);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addObservableListListener([list, pos | pos2 = pos]) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerDuplicate_transitions0_actions1() {
        try {

            this.highscoreList.addResult(Integer.valueOf(5));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(5) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerDuplicate_transitions0_actions2() {
        try {

            this.highscoreList.addResult(Integer.valueOf(6));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(6) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerDuplicate_transitions0_actions3() {
        try {

            this.highscoreList.addResult(Integer.valueOf(2));
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList.addResult(2) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerDuplicate_transitions0_effects0_state() {
        this._test__listListenerDuplicate_transitions0_effects0_state_objectTests0_test();

    }

    private void _test__listListenerDuplicate_transitions0_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 5, 6});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addObservableListListener([list, pos | pos2 = pos]) ,highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
        }

    }

    private void _transition_exprAction__listListenerDuplicate_transitions1_actions0() {
        try {

            this.addResult(1, 2);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("addResult(1, 2) failed: " + error.getMessage());
        }

    }

    private void _test__listListenerDuplicate_transitions1_effects0_state() {
        this._test__listListenerDuplicate_transitions1_effects0_state_objectTests0_test();

    }

    private void _test__listListenerDuplicate_transitions1_effects0_state_objectTests0_test() {
        try {

            this.operator_assertEquals(
                    this.highscoreList, new int[]{2, 2, 5});
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("highscoreList ?= #[2, 2, 5] failed after addResult(1, 2): " + error.getMessage());
        }

    }
}

