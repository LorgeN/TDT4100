package org.tanberg.oving8.stocks;

import org.tanberg.oving8.stocks.events.EventHandler;
import org.tanberg.oving8.stocks.events.Listener;

import java.util.Arrays;

public class StockIndex implements Listener {

    private final String name;
    private Stock[] stocks;
    private double index;

    public StockIndex(String name, Stock... stocks) {
        this.name = name;
        this.stocks = stocks;

        this.index = Arrays.stream(this.stocks).mapToDouble(Stock::getPrice).sum();

        StockExchange.getInstance().getEventManager().registerListener(this);
    }

    public String getName() {
        return name;
    }

    public Stock[] getStocks() {
        return stocks;
    }

    public void addStock(Stock stock) {
        if (this.hasStock(stock)) {
            return;
        }

        this.stocks = Arrays.copyOf(this.stocks, this.stocks.length + 1);
        this.stocks[this.stocks.length - 1] = stock;

        this.index += stock.getPrice();
    }

    public void removeStock(Stock stock) {
        int index = -1;
        for (int i = 0; i < this.stocks.length; i++) {
            if (!this.stocks[i].equals(stock)) {
                continue;
            }

            index = i;
            break;
        }

        if (index == -1) {
            return;
        }

        Stock[] previous = this.stocks;
        this.stocks = new Stock[this.stocks.length - 1];
        System.arraycopy(previous, 0, this.stocks, 0, index);
        System.arraycopy(previous, index, this.stocks, index, this.stocks.length - index);

        this.index -= stock.getPrice();
    }

    public boolean hasStock(Stock stock) {
        return Arrays.asList(this.getStocks()).contains(stock);
    }

    public double getIndex() {
        return index;
    }

    @EventHandler
    public void onStockUpdate(StockPriceChangeEvent event) {
        if (!this.hasStock(event.getStock())) {
            return;
        }

        this.index += event.getDifference();
    }
}
