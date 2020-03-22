package org.tanberg.oving8.stocks;

import org.tanberg.oving8.stocks.events.Event;
import org.tanberg.oving8.stocks.events.HandlerList;

public class StockPriceChangeEvent extends Event<StockPriceChangeEvent> {

    private static final HandlerList<StockPriceChangeEvent> HANDLER_LIST = new HandlerList<>();

    private final Stock stock;
    private final double oldPrice;
    private final double newPrice;

    public StockPriceChangeEvent(Stock stock, double oldPrice, double newPrice) {
        this.stock = stock;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public Stock getStock() {
        return stock;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public double getDifference() {
        return this.getNewPrice() - this.getOldPrice();
    }

    @Override
    public HandlerList<StockPriceChangeEvent> getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList<StockPriceChangeEvent> getHandlerList() {
        return HANDLER_LIST;
    }
}
