package org.tanberg.oving8.stocks;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

public class Stock {

    private final List<StockListener> listeners;
    private final String ticker;
    private double value;

    public Stock(String ticker, double value) {
        this.ticker = ticker;
        this.value = value;

        this.listeners = Lists.newArrayList();
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return value;
    }

    public void setPrice(double value) {
        double oldValue = this.value;
        this.value = value;

        StockPriceChangeEvent event = new StockPriceChangeEvent(this, oldValue, value);
        StockExchange.getInstance().getEventManager().callEvent(event);

        this.listeners.forEach(listener -> listener.stockPriceChanged(this, oldValue, value));
    }

    public void addStockListener(StockListener listener) {
        this.listeners.add(listener);
    }

    public void removeStockListener(StockListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Stock stock = (Stock) o;
        return Double.compare(stock.value, value) == 0 &&
                Objects.equals(ticker, stock.ticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, value);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ticker='" + ticker + '\'' +
                ", value=" + value +
                '}';
    }
}
