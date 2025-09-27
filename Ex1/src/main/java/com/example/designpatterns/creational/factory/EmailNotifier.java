package com.example.designpatterns.creational.factory;

import java.util.Random;
import java.util.logging.Logger;

public class EmailNotifier implements Notifier {
    private static final Logger LOG = java.util.logging.Logger.getLogger(EmailNotifier.class.getName());
    private final Random rnd = new Random();

    @Override
    public void send(String recipient, String message) throws NotificationException {
        if (recipient == null || recipient.isBlank()) throw new NotificationException("Invalid recipient");
        if (rnd.nextInt(10) < 2) { // 20% chance
            throw new RuntimeException("Transient SMTP error");
        }
        LOG.info(() -> String.format("Email sent to %s: %s", recipient, message));
    }
}
