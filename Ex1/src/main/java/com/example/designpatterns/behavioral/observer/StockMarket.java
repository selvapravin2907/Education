package com.example.designpatterns.behavioral.observer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class StockMarket {
    private static final Logger LOG = java.util.logging.Logger.getLogger(StockMarket.class.getName());

    private final Map<String, Double> prices = new ConcurrentHashMap<>();
    private final List<MarketObserver> observers = Collections.synchronizedList(new ArrayList<>());

    public void registerObserver(MarketObserver obs) {
        Objects.requireNonNull(obs);
        observers.add(obs);
        LOG.info("Observer registered: " + obs.getClass().getSimpleName());
    }

    public void unregisterObserver(MarketObserver obs) {
        observers.remove(obs);
        LOG.info("Observer unregistered: " + obs.getClass().getSimpleName());
    }

    public void setPrice(String symbol, double price) {
        if (symbol == null || symbol.isBlank()) throw new IllegalArgumentException("symbol");
        if (price < 0) throw new IllegalArgumentException("price must be non-negative");
        prices.put(symbol, price);
        notifyObservers(symbol, price);
    }

    private void notifyObservers(String symbol, double price) {
        synchronized (observers) {
            for (MarketObserver obs : new ArrayList<>(observers)) {
                try {
                    obs.onPriceChanged(symbol, price);
                } catch (Exception ex) {
                    LOG.warning("Observer threw: " + ex.getMessage());
                }
            }
        }
    }
}
