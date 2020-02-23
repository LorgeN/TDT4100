package org.tanberg.oving5;

import com.google.common.collect.Maps;
import org.tanberg.oving1.StopWatch;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class StopWatchManager {

    private final Map<String, StopWatch> stopWatches;

    public StopWatchManager() {
        this.stopWatches = Maps.newConcurrentMap();
    }

    public StopWatch getStopWatch(String name) {
        return this.stopWatches.get(name);
    }

    public StopWatch newStopWatch(String name) {
        if (this.stopWatches.containsKey(name)) {
            throw new IllegalArgumentException("Already exists!");
        }

        StopWatch stopWatch = new StopWatch();
        this.stopWatches.put(name, stopWatch);
        return stopWatch;
    }

    public void removeStopWatch(String name) {
        this.stopWatches.remove(name);
    }

    public void tick(int ticks) {
        this.getAllWatches().forEach(watch -> watch.tick(ticks));
    }

    public Collection<StopWatch> getAllWatches() {
        return this.stopWatches.values();
    }

    public Collection<StopWatch> getStartedWatches() {
        return this.getAllWatches().stream()
                .filter(StopWatch::isStarted)
                .collect(Collectors.toList());
    }

    public Collection<StopWatch> getStoppedWatches() {
        return this.getAllWatches().stream()
                .filter(StopWatch::isStopped)
                .collect(Collectors.toList());
    }
}
