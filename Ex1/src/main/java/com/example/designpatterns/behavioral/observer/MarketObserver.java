package com.example.designpatterns.behavioral.observer;

public interface MarketObserver {
    void onPriceChanged(String symbol, double newPrice);
}
