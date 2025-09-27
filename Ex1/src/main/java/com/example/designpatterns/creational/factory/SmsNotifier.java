package com.example.designpatterns.creational.factory;

import java.util.Random;
import java.util.logging.Logger;

public class SmsNotifier implements Notifier {
    private static final Logger LOG = java.util.logging.Logger.getLogger(SmsNotifier.class.getName());
    private final Random rnd = new Random();

    @Override
    public void send(String recipient, String message) throws NotificationException {
        if (recipient == null || recipient.isBlank()) throw new NotificationException("Invalid recipient");
        if (rnd.nextInt(10) < 1) { // 10% chance
            throw new RuntimeException("Transient SMS gateway error");
        }
        LOG.info(() -> String.format("SMS sent to %s: %s", recipient, message));
    }
}
