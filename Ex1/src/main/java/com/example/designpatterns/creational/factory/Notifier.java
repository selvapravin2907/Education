package com.example.designpatterns.creational.factory;

public interface Notifier {
    void send(String recipient, String message) throws NotificationException;
}
