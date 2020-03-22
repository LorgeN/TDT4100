package org.tanberg.oving8.stocks.events;

/**
 * An abstract event
 *
 * @param <T> This event as a type (E. g. {@code ExampleEvent extends Event<ExampleEvent>})
 */
public abstract class Event<T extends Event<T>> {

    public abstract HandlerList<T> getHandlers();
}
