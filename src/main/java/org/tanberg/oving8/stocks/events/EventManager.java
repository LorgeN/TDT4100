package org.tanberg.oving8.stocks.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Simple event system manager
 */
public class EventManager {

    public <T extends Event<T>> void callEvent(T event) {
        HandlerList<T> handlerList = event.getHandlers();
        handlerList.call(event);
    }

    public void registerListener(Listener listener) {
        System.out.println("Registering listener " + listener.getClass().getSimpleName() + "...");

        Class<? extends Listener> consider = listener.getClass();
        while (true) {
            this.registerListener(listener, consider);

            Class<?> superClass = consider.getSuperclass();
            if (superClass == null || !Listener.class.isAssignableFrom(superClass)) {
                break;
            }

            consider = (Class<? extends Listener>) superClass;
        }

        System.out.println("Registered listener " + listener.getClass().getSimpleName() + "!");
    }

    public void registerListener(Listener listener, Class<? extends Listener> consider) {
        for (Method method : consider.getDeclaredMethods()) {
            EventHandler annotation = method.getAnnotation(EventHandler.class);
            if (annotation == null) {
                continue;
            }

            Class<?>[] classes = method.getParameterTypes();
            if (classes.length != 1) {
                throw new ListenerRegisterException(method.getName() + " doesn't have 1 argument!");
            }

            try {
                HandlerList<?> handlerList = this.getHandlerList(classes[0]);
                int priority = annotation.priority();

                RegisteredListener registeredListener = new RegisteredListener<>(listener, priority, method);

                handlerList.addListener(registeredListener);
                System.out.println("Registered event handler " + method.getName() + "!");
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new ListenerRegisterException("An error occurred while parsing " + method.getName() + " for listener " + listener.getClass().getSimpleName() + "!", e);
            }
        }
    }

    public <T> HandlerList<T> getHandlerList(Class<T> eventClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!Event.class.isAssignableFrom(eventClass)) {
            throw new IllegalArgumentException(eventClass.getSimpleName() + " isn't an event!");
        }

        Method method = eventClass.getDeclaredMethod("getHandlerList");
        return (HandlerList<T>) method.invoke(null);
    }
}
