package com.example.designpatterns.behavioral.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percent; // 0.10 = 10%

    public PercentageDiscountStrategy(double percent) {
        if (percent < 0 || percent > 1) throw new IllegalArgumentException("percent between 0 and 1");
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount * (1.0 - percent);
    }
}
