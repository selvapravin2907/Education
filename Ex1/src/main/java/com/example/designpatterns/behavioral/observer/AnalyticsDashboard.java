package com.example.designpatterns.behavioral.observer;

import java.util.logging.Logger;

public class AnalyticsDashboard implements MarketObserver {
    private static final Logger LOG = java.util.logging.Logger.getLogger(AnalyticsDashboard.class.getName());

    @Override
    public void onPriceChanged(String symbol, double newPrice) {
        LOG.info(() -> String.format("Analytics: %s changed to %.2f — computing indicators...", symbol, newPrice));
    }
}
