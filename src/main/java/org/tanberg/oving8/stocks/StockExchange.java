package org.tanberg.oving8.stocks;

import org.tanberg.oving8.stocks.events.EventManager;
import org.tanberg.oving8.stocks.events.Listener;

public class StockExchange implements Listener {

    private static final StockExchange EXCHANGE = new StockExchange();

    public static StockExchange getInstance() {
        return EXCHANGE;
    }

    private final EventManager eventManager;

    private StockExchange() {
        this.eventManager = new EventManager();
        this.eventManager.registerListener(this);
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void registerIndex(StockIndex index) {
        this.eventManager.registerListener(index);
    }
}
