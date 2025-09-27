package com.example.designpatterns.structural.adapter;

import java.util.HashMap;
import java.util.Map;

public class PaymentAdapter implements NewPaymentGateway {
    private final LegacyPaymentProcessor legacy;

    public PaymentAdapter(LegacyPaymentProcessor legacy) {
        this.legacy = legacy;
    }

    @Override
    public boolean charge(String cardNumber, double amount) {
        if (cardNumber == null || cardNumber.isBlank()) throw new IllegalArgumentException("cardNumber");
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");
        Map<String,String> params = new HashMap<>();
        params.put("card", cardNumber);
        params.put("amount", Double.toString(amount));
        return legacy.pay(params);
    }
}
