package org.tanberg.oving8.stocks.events;

import java.lang.reflect.Method;

public class RegisteredListener<T extends Event> {

    private Listener listener;
    private int priority;
    private Method method;

    public RegisteredListener(Listener listener, int priority, Method method) {
        this.listener = listener;
        this.priority = priority;
        this.method = method;
    }

    public Listener getListener() {
        return listener;
    }

    public int getPriority() {
        return priority;
    }

    public Method getMethod() {
        return method;
    }

    public void call(T event) throws EventException {
        if (event == null) {
            throw new IllegalArgumentException("Event can't be null!");
        }

        this.invoke(event);
    }

    private void invoke(T event) throws EventException {
        try {
            this.method.invoke(this.listener, event);
        } catch (Throwable t) {
            throw new EventException("An error occurred while calling " + event.getClass().getSimpleName() + " for " +
                    this.listener.getClass().getSimpleName() + "!", t);
        }
    }
}
