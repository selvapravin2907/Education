package com.example.designpatterns.behavioral.strategy;

import java.util.Objects;
import java.util.logging.Logger;

public class PricingEngine {
    private static final Logger LOG = java.util.logging.Logger.getLogger(PricingEngine.class.getName());

    private DiscountStrategy strategy;

    public PricingEngine(DiscountStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public double computeFinalPrice(Order order) {
        double base = Objects.requireNonNull(order).total();
        double finalPrice = strategy.applyDiscount(base);
        LOG.info(() -> String.format("Base: %.2f, Final after %s: %.2f", base, strategy.getClass().getSimpleName(), finalPrice));
        return finalPrice;
    }
}
