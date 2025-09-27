package com.example.designpatterns.structural.adapter;

import java.util.Map;

// A legacy class we cannot change (simulated)
public class LegacyPaymentProcessor {
    public boolean pay(Map<String,String> params) {
        if (!params.containsKey("card") || !params.containsKey("amount")) return false;
        return true;
    }
}
