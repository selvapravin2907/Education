package com.example.designpatterns.structural.decorator;

import com.example.designpatterns.creational.factory.Notifier;
import com.example.designpatterns.creational.factory.NotificationException;

import java.util.logging.Logger;

public class LoggingNotifierDecorator extends NotifierDecorator {
    private static final Logger LOG = java.util.logging.Logger.getLogger(LoggingNotifierDecorator.class.getName());

    public LoggingNotifierDecorator(Notifier delegate) { super(delegate); }

    @Override
    public void send(String recipient, String message) throws NotificationException {
        LOG.info(() -> String.format("Sending to %s using %s", recipient, delegate.getClass().getSimpleName()));
        delegate.send(recipient, message);
    }
}
