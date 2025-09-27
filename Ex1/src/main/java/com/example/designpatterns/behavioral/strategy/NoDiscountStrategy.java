package com.example.designpatterns.behavioral.strategy;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount;
    }
}
