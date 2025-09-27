package com.example.designpatterns.behavioral.observer;

import java.util.logging.Logger;

public class Trader implements MarketObserver {
    private static final Logger LOG = java.util.logging.Logger.getLogger(Trader.class.getName());
    private final String name;
    private final double buyThreshold;

    public Trader(String name, double buyThreshold) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name");
        if (buyThreshold < 0) throw new IllegalArgumentException("buyThreshold");
        this.name = name;
        this.buyThreshold = buyThreshold;
    }

    @Override
    public void onPriceChanged(String symbol, double newPrice) {
        LOG.info(() -> String.format("Trader %s notified: %s -> %.2f", name, symbol, newPrice));
        if (newPrice <= buyThreshold) {
            LOG.info(() -> String.format("Trader %s decides to BUY %s at %.2f", name, symbol, newPrice));
        }
    }
}


