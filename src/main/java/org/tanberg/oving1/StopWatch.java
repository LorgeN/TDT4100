package org.tanberg.oving1;

import java.util.Arrays;

public class StopWatch {

    private int lifeTime;
    private StopwatchState state;
    private int[] laps;
    private int total;
    private int current;

    public StopWatch() {
        this.state = StopwatchState.NOT_STARTED;
        this.laps = new int[0];
        this.current = this.total = this.lifeTime = 0;
    }

    public boolean isStarted() {
        return this.state != StopwatchState.NOT_STARTED;
    }

    public boolean isStopped() {
        return this.state == StopwatchState.STOPPED;
    }

    public int getTicks() {
        return this.lifeTime;
    }

    public int getTime() {
        if (!this.isStarted()) {
            return -1;
        }

        return this.total;
    }

    public int getLapTime() {
        if (!this.isStarted()) {
            return -1;
        }

        return this.current;
    }

    public int getLastLapTime() {
        if (this.laps.length == 0) {
            return -1;
        }

        return this.laps[this.laps.length - 1];
    }

    public void tick(int ticks) {
        this.lifeTime += ticks;
        if (this.state != StopwatchState.RUNNING) {
            return;
        }

        this.total += ticks;
        this.current += ticks;
    }

    public void start() {
        this.state = StopwatchState.RUNNING;
    }

    public void lap() {
        if (!this.isStarted()) {
            return;
        }

        this.laps = Arrays.copyOf(this.laps, this.laps.length + 1);
        this.laps[this.laps.length - 1] = this.current;
        this.current = 0;
    }

    public void stop() {
        this.lap();
        this.state = StopwatchState.STOPPED;
    }

    public enum StopwatchState {
        NOT_STARTED,
        RUNNING,
        STOPPED
    }
}
