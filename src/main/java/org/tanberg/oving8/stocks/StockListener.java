package org.tanberg.oving8.stocks;

public interface StockListener {

    void stockPriceChanged(Stock stock, double oldValue, double newValue);
}
