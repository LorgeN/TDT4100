package org.tanberg.oving5;

import com.google.common.base.Objects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tanberg.oving1.StopWatch;

import java.util.Collection;

public class StopWatchManagerTest {
    private StopWatchManager stopWatchManager;

    private StopWatchManager _init_stopWatchManager() {
        StopWatchManager _stopWatchManager = new StopWatchManager();
        return _stopWatchManager;
    }

    @Before
    public void setUp() {
        stopWatchManager = _init_stopWatchManager();

    }


    @Test
    public void testTicks() {
        StopWatch sw1 = _init__ticks_sw1();
        StopWatch sw2 = _init__ticks_sw2();
        _transition_exprAction__ticks_transitions0_actions0(stopWatchManager, sw1, sw2);
        _test__ticks_transitions0_effects0_state(stopWatchManager, sw1, sw2);
        _transition_exprAction__ticks_transitions1_actions0(stopWatchManager, sw1, sw2);
        _test__ticks_transitions1_effects0_state(stopWatchManager, sw1, sw2);

    }

    @Test
    public void testNewRemoveStopWatches() {
        _test__newRemoveStopWatches_transitions0_effects0_state(stopWatchManager);
        _transition_exprAction__newRemoveStopWatches_transitions1_actions0(stopWatchManager);
        _test__newRemoveStopWatches_transitions1_effects0_state(stopWatchManager);
        _transition_exprAction__newRemoveStopWatches_transitions2_actions0(stopWatchManager);
        _test__newRemoveStopWatches_transitions2_effects0_state(stopWatchManager);
        _transition_exprAction__newRemoveStopWatches_transitions3_actions0(stopWatchManager);
        _test__newRemoveStopWatches_transitions3_effects0_state(stopWatchManager);
        _transition_exprAction__newRemoveStopWatches_transitions4_actions0(stopWatchManager);
        _test__newRemoveStopWatches_transitions4_effects0_state(stopWatchManager);

    }

    @Test
    public void testStartedStoppedWatches() {
        _test__startedStoppedWatches_transitions0_effects0_state(stopWatchManager);
        _transition_exprAction__startedStoppedWatches_transitions1_actions0(stopWatchManager);
        _test__startedStoppedWatches_transitions1_effects0_state(stopWatchManager);
        _transition_exprAction__startedStoppedWatches_transitions2_actions0(stopWatchManager);
        _test__startedStoppedWatches_transitions2_effects0_state(stopWatchManager);
        _transition_exprAction__startedStoppedWatches_transitions3_actions0(stopWatchManager);
        _test__startedStoppedWatches_transitions3_effects0_state(stopWatchManager);
        _transition_exprAction__startedStoppedWatches_transitions4_actions0(stopWatchManager);
        _test__startedStoppedWatches_transitions4_effects0_state(stopWatchManager);

    }

    private StopWatch _init__ticks_sw1() {
        StopWatch _newStopWatch = this.stopWatchManager.newStopWatch("SW 1");
        return _newStopWatch;
    }

    private StopWatch _init__ticks_sw2() {
        StopWatch _newStopWatch = this.stopWatchManager.newStopWatch("SW 2");
        return _newStopWatch;
    }

    private void _transition_exprAction__ticks_transitions0_actions0(final StopWatchManager it, final StopWatch sw1, final StopWatch sw2) {
        try {

            it.tick(1);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("tick(1) failed: " + error.getMessage());
        }

    }

    private void _test__ticks_transitions0_effects0_state(final StopWatchManager it, final StopWatch sw1, final StopWatch sw2) {
        _test__ticks_transitions0_effects0_state_objectTests0_test(sw1, sw1, sw2);
        _test__ticks_transitions0_effects0_state_objectTests1_test(sw2, sw1, sw2);

    }

    private void _test__ticks_transitions0_effects0_state_objectTests0_test(final StopWatch it, final StopWatch sw1, final StopWatch sw2) {

        int _ticks = it.getTicks();
        Assert.assertEquals("ticks == 1 failed after tick(1)", 1, _ticks);

    }

    private void _test__ticks_transitions0_effects0_state_objectTests1_test(final StopWatch it, final StopWatch sw1, final StopWatch sw2) {

        int _ticks = it.getTicks();
        Assert.assertEquals("ticks == 1 failed after tick(1)", 1, _ticks);

    }

    private void _transition_exprAction__ticks_transitions1_actions0(final StopWatchManager it, final StopWatch sw1, final StopWatch sw2) {
        try {

            it.tick(4);
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("tick(4) failed: " + error.getMessage());
        }

    }

    private void _test__ticks_transitions1_effects0_state(final StopWatchManager it, final StopWatch sw1, final StopWatch sw2) {
        _test__ticks_transitions1_effects0_state_objectTests0_test(sw1, sw1, sw2);
        _test__ticks_transitions1_effects0_state_objectTests1_test(sw2, sw1, sw2);

    }

    private void _test__ticks_transitions1_effects0_state_objectTests0_test(final StopWatch it, final StopWatch sw1, final StopWatch sw2) {

        int _ticks = it.getTicks();
        Assert.assertEquals("ticks == 5 failed after tick(4)", 5, _ticks);

    }

    private void _test__ticks_transitions1_effects0_state_objectTests1_test(final StopWatch it, final StopWatch sw1, final StopWatch sw2) {

        int _ticks = it.getTicks();
        Assert.assertEquals("ticks == 5 failed after tick(4)", 5, _ticks);

    }

    private void _test__newRemoveStopWatches_transitions0_effects0_state(final StopWatchManager it) {
        _test__newRemoveStopWatches_transitions0_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__newRemoveStopWatches_transitions0_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _allWatches = it.getAllWatches();
        int _size = _allWatches.size();
        Assert.assertEquals("allWatches.size == 0 failed", 0, _size);

    }

    private void _transition_exprAction__newRemoveStopWatches_transitions1_actions0(final StopWatchManager it) {
        try {

            it.newStopWatch("SW 1");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("newStopWatch(\"SW 1\") failed: " + error.getMessage());
        }

    }

    private void _test__newRemoveStopWatches_transitions1_effects0_state(final StopWatchManager it) {
        _test__newRemoveStopWatches_transitions1_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__newRemoveStopWatches_transitions1_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _allWatches = it.getAllWatches();
        int _size = _allWatches.size();
        Assert.assertEquals("allWatches.size == 1 failed after newStopWatch(\"SW 1\")", 1, _size);

        StopWatch _stopWatch = it.getStopWatch("SW 1");
        Assert.assertTrue("getStopWatch(\"SW 1\") != null failed after newStopWatch(\"SW 1\")", (!Objects.equal(_stopWatch, null)));

    }

    private void _transition_exprAction__newRemoveStopWatches_transitions2_actions0(final StopWatchManager it) {
        try {

            it.newStopWatch("SW 2");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("newStopWatch(\"SW 2\") failed: " + error.getMessage());
        }

    }

    private void _test__newRemoveStopWatches_transitions2_effects0_state(final StopWatchManager it) {
        _test__newRemoveStopWatches_transitions2_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__newRemoveStopWatches_transitions2_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _allWatches = it.getAllWatches();
        int _size = _allWatches.size();
        Assert.assertEquals("allWatches.size == 2 failed after newStopWatch(\"SW 2\")", 2, _size);

        StopWatch _stopWatch = it.getStopWatch("SW 1");
        boolean _notEquals = (!Objects.equal(_stopWatch, null));
        Assert.assertTrue("getStopWatch(\"SW 1\") != null failed after newStopWatch(\"SW 2\")", _notEquals);

        StopWatch _stopWatch_1 = it.getStopWatch("SW 2");
        Assert.assertTrue("getStopWatch(\"SW 2\") != null failed after newStopWatch(\"SW 2\")", (!Objects.equal(_stopWatch_1, null)));

    }

    private void _transition_exprAction__newRemoveStopWatches_transitions3_actions0(final StopWatchManager it) {
        try {

            it.removeStopWatch("SW 1");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("removeStopWatch(\"SW 1\") failed: " + error.getMessage());
        }

    }

    private void _test__newRemoveStopWatches_transitions3_effects0_state(final StopWatchManager it) {
        _test__newRemoveStopWatches_transitions3_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__newRemoveStopWatches_transitions3_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _allWatches = it.getAllWatches();
        int _size = _allWatches.size();
        Assert.assertEquals("allWatches.size == 1 failed after removeStopWatch(\"SW 1\")", 1, _size);

        StopWatch _stopWatch = it.getStopWatch("SW 1");
        Assert.assertEquals("getStopWatch(\"SW 1\") == null failed after removeStopWatch(\"SW 1\")", null, _stopWatch);

        StopWatch _stopWatch_1 = it.getStopWatch("SW 2");
        Assert.assertTrue("getStopWatch(\"SW 2\") != null failed after removeStopWatch(\"SW 1\")", (!Objects.equal(_stopWatch_1, null)));

    }

    private void _transition_exprAction__newRemoveStopWatches_transitions4_actions0(final StopWatchManager it) {
        try {

            it.removeStopWatch("SW 2");
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("removeStopWatch(\"SW 2\") failed: " + error.getMessage());
        }

    }

    private void _test__newRemoveStopWatches_transitions4_effects0_state(final StopWatchManager it) {
        _test__newRemoveStopWatches_transitions4_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__newRemoveStopWatches_transitions4_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _allWatches = it.getAllWatches();
        int _size = _allWatches.size();
        Assert.assertEquals("allWatches.size == 0 failed after removeStopWatch(\"SW 2\")", 0, _size);

        StopWatch _stopWatch = it.getStopWatch("SW 1");
        Assert.assertEquals("getStopWatch(\"SW 1\") == null failed after removeStopWatch(\"SW 2\")", null, _stopWatch);

        StopWatch _stopWatch_1 = it.getStopWatch("SW 2");
        Assert.assertEquals("getStopWatch(\"SW 2\") == null failed after removeStopWatch(\"SW 2\")", null, _stopWatch_1);

    }

    private void _test__startedStoppedWatches_transitions0_effects0_state(final StopWatchManager it) {
        _test__startedStoppedWatches_transitions0_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__startedStoppedWatches_transitions0_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _startedWatches = it.getStartedWatches();
        int _size = _startedWatches.size();
        Assert.assertEquals("startedWatches.size == 0 failed", 0, _size);

        Collection<StopWatch> _stoppedWatches = it.getStoppedWatches();
        int _size_1 = _stoppedWatches.size();
        Assert.assertEquals("stoppedWatches.size == 0 failed", 0, _size_1);

    }

    private void _transition_exprAction__startedStoppedWatches_transitions1_actions0(final StopWatchManager it) {
        try {

            StopWatch _newStopWatch = it.newStopWatch("SW 1");
            _newStopWatch.start();
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("newStopWatch(\"SW 1\").start() failed: " + error.getMessage());
        }

    }

    private void _test__startedStoppedWatches_transitions1_effects0_state(final StopWatchManager it) {
        _test__startedStoppedWatches_transitions1_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__startedStoppedWatches_transitions1_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _startedWatches = it.getStartedWatches();
        int _size = _startedWatches.size();
        Assert.assertEquals("startedWatches.size == 1 failed after newStopWatch(\"SW 1\").start()", 1, _size);

        Collection<StopWatch> _startedWatches_1 = it.getStartedWatches();
        StopWatch _stopWatch = it.getStopWatch("SW 1");
        boolean _contains = _startedWatches_1.contains(_stopWatch);
        Assert.assertTrue("startedWatches.contains(getStopWatch(\"SW 1\")) failed after newStopWatch(\"SW 1\").start()", _contains);

        StopWatch _stopWatch_1 = it.getStopWatch("SW 1");
        boolean _isStarted = _stopWatch_1.isStarted();
        Assert.assertTrue("getStopWatch(\"SW 1\").isStarted failed after newStopWatch(\"SW 1\").start()", _isStarted);

        Collection<StopWatch> _stoppedWatches = it.getStoppedWatches();
        int _size_1 = _stoppedWatches.size();
        Assert.assertEquals("stoppedWatches.size == 0 failed after newStopWatch(\"SW 1\").start()", 0, _size_1);

    }

    private void _transition_exprAction__startedStoppedWatches_transitions2_actions0(final StopWatchManager it) {
        try {

            StopWatch _newStopWatch = it.newStopWatch("SW 2");
            _newStopWatch.start();
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("newStopWatch(\"SW 2\").start() failed: " + error.getMessage());
        }

    }

    private void _test__startedStoppedWatches_transitions2_effects0_state(final StopWatchManager it) {
        _test__startedStoppedWatches_transitions2_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__startedStoppedWatches_transitions2_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _startedWatches = it.getStartedWatches();
        int _size = _startedWatches.size();
        Assert.assertEquals("startedWatches.size == 2 failed after newStopWatch(\"SW 2\").start()", 2, _size);

        Collection<StopWatch> _startedWatches_1 = it.getStartedWatches();
        StopWatch _stopWatch = it.getStopWatch("SW 1");
        boolean _contains = _startedWatches_1.contains(_stopWatch);
        Assert.assertTrue("startedWatches.contains(getStopWatch(\"SW 1\")) failed after newStopWatch(\"SW 2\").start()", _contains);

        StopWatch _stopWatch_1 = it.getStopWatch("SW 1");
        boolean _isStarted = _stopWatch_1.isStarted();
        Assert.assertTrue("getStopWatch(\"SW 1\").isStarted failed after newStopWatch(\"SW 2\").start()", _isStarted);

        Collection<StopWatch> _startedWatches_2 = it.getStartedWatches();
        StopWatch _stopWatch_2 = it.getStopWatch("SW 2");
        boolean _contains_1 = _startedWatches_2.contains(_stopWatch_2);
        Assert.assertTrue("startedWatches.contains(getStopWatch(\"SW 2\")) failed after newStopWatch(\"SW 2\").start()", _contains_1);

        StopWatch _stopWatch_3 = it.getStopWatch("SW 2");
        boolean _isStarted_1 = _stopWatch_3.isStarted();
        Assert.assertTrue("getStopWatch(\"SW 2\").isStarted failed after newStopWatch(\"SW 2\").start()", _isStarted_1);

        Collection<StopWatch> _stoppedWatches = it.getStoppedWatches();
        int _size_1 = _stoppedWatches.size();
        Assert.assertEquals("stoppedWatches.size == 0 failed after newStopWatch(\"SW 2\").start()", 0, _size_1);

        StopWatch _stopWatch_4 = it.getStopWatch("SW 1");
        boolean _isStopped = _stopWatch_4.isStopped();
        boolean _not = (!_isStopped);
        Assert.assertTrue("! getStopWatch(\"SW 1\").isStopped failed after newStopWatch(\"SW 2\").start()", _not);

        StopWatch _stopWatch_5 = it.getStopWatch("SW 2");
        boolean _isStopped_1 = _stopWatch_5.isStopped();
        Assert.assertTrue("! getStopWatch(\"SW 2\").isStopped failed after newStopWatch(\"SW 2\").start()", (!_isStopped_1));

    }

    private void _transition_exprAction__startedStoppedWatches_transitions3_actions0(final StopWatchManager it) {
        try {

            StopWatch _stopWatch = it.getStopWatch("SW 2");
            _stopWatch.stop();
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("getStopWatch(\"SW 2\").stop() failed: " + error.getMessage());
        }

    }

    private void _test__startedStoppedWatches_transitions3_effects0_state(final StopWatchManager it) {
        _test__startedStoppedWatches_transitions3_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__startedStoppedWatches_transitions3_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _stoppedWatches = it.getStoppedWatches();
        int _size = _stoppedWatches.size();
        Assert.assertEquals("stoppedWatches.size == 1 failed after getStopWatch(\"SW 2\").stop()", 1, _size);

        Collection<StopWatch> _stoppedWatches_1 = it.getStoppedWatches();
        StopWatch _stopWatch = it.getStopWatch("SW 1");
        boolean _contains = _stoppedWatches_1.contains(_stopWatch);
        boolean _not = (!_contains);
        Assert.assertTrue("! stoppedWatches.contains(getStopWatch(\"SW 1\")) failed after getStopWatch(\"SW 2\").stop()", _not);

        StopWatch _stopWatch_1 = it.getStopWatch("SW 1");
        boolean _isStopped = _stopWatch_1.isStopped();
        boolean _not_1 = (!_isStopped);
        Assert.assertTrue("! getStopWatch(\"SW 1\").isStopped failed after getStopWatch(\"SW 2\").stop()", _not_1);

        Collection<StopWatch> _stoppedWatches_2 = it.getStoppedWatches();
        StopWatch _stopWatch_2 = it.getStopWatch("SW 2");
        boolean _contains_1 = _stoppedWatches_2.contains(_stopWatch_2);
        Assert.assertTrue("stoppedWatches.contains(getStopWatch(\"SW 2\")) failed after getStopWatch(\"SW 2\").stop()", _contains_1);

        StopWatch _stopWatch_3 = it.getStopWatch("SW 2");
        Assert.assertTrue("getStopWatch(\"SW 2\").isStopped failed after getStopWatch(\"SW 2\").stop()", _stopWatch_3.isStopped());

    }

    private void _transition_exprAction__startedStoppedWatches_transitions4_actions0(final StopWatchManager it) {
        try {

            StopWatch _stopWatch = it.getStopWatch("SW 1");
            _stopWatch.stop();
        } catch (junit.framework.AssertionFailedError error) {
            Assert.fail("getStopWatch(\"SW 1\").stop() failed: " + error.getMessage());
        }

    }

    private void _test__startedStoppedWatches_transitions4_effects0_state(final StopWatchManager it) {
        _test__startedStoppedWatches_transitions4_effects0_state_objectTests0_test(stopWatchManager);

    }

    private void _test__startedStoppedWatches_transitions4_effects0_state_objectTests0_test(final StopWatchManager it) {

        Collection<StopWatch> _stoppedWatches = it.getStoppedWatches();
        int _size = _stoppedWatches.size();
        Assert.assertEquals("stoppedWatches.size == 2 failed after getStopWatch(\"SW 1\").stop()", 2, _size);

        Collection<StopWatch> _stoppedWatches_1 = it.getStoppedWatches();
        StopWatch _stopWatch = it.getStopWatch("SW 1");
        boolean _contains = _stoppedWatches_1.contains(_stopWatch);
        Assert.assertTrue("stoppedWatches.contains(getStopWatch(\"SW 1\")) failed after getStopWatch(\"SW 1\").stop()", _contains);

        StopWatch _stopWatch_1 = it.getStopWatch("SW 1");
        boolean _isStopped = _stopWatch_1.isStopped();
        Assert.assertTrue("getStopWatch(\"SW 1\").isStopped failed after getStopWatch(\"SW 1\").stop()", _isStopped);

        Collection<StopWatch> _stoppedWatches_2 = it.getStoppedWatches();
        StopWatch _stopWatch_2 = it.getStopWatch("SW 2");
        boolean _contains_1 = _stoppedWatches_2.contains(_stopWatch_2);
        Assert.assertTrue("stoppedWatches.contains(getStopWatch(\"SW 2\")) failed after getStopWatch(\"SW 1\").stop()", _contains_1);

        StopWatch _stopWatch_3 = it.getStopWatch("SW 2");
        Assert.assertTrue("getStopWatch(\"SW 2\").isStopped failed after getStopWatch(\"SW 1\").stop()", _stopWatch_3.isStopped());

    }
}

