package com.example.designpatterns.structural.adapter;

public interface NewPaymentGateway {
    boolean charge(String cardNumber, double amount);
}
