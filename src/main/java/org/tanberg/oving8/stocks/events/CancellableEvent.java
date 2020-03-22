package org.tanberg.oving8.stocks.events;

public abstract class CancellableEvent<T extends CancellableEvent<T>> extends Event<T> implements Cancellable {

    private boolean cancelled;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
