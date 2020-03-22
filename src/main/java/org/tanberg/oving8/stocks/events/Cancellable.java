package org.tanberg.oving8.stocks.events;

public interface Cancellable {

    boolean isCancelled();

    void setCancelled(boolean cancelled);
}
