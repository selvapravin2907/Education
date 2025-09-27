package com.example.designpatterns.structural.decorator;

import com.example.designpatterns.creational.factory.Notifier;
import com.example.designpatterns.creational.factory.NotifierFactory;
import com.example.designpatterns.creational.factory.NotificationException;
import com.example.designpatterns.util.RetryPolicy;

public class DecoratorDemo {
    public static void runDemo() {
        Notifier base = NotifierFactory.create("email");
        Notifier logged = new LoggingNotifierDecorator(base);
        Notifier reliable = new RetryNotifierDecorator(logged, new RetryPolicy(3, 200));
        try {
            reliable.send("user@example.com", "Hello from decorated notifier!");
        } catch (NotificationException e) {
            System.err.println("Notification failed: " + e.getMessage());
        }
    }
}
