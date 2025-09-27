package com.example.designpatterns.structural.decorator;

import com.example.designpatterns.creational.factory.Notifier;
import com.example.designpatterns.creational.factory.NotificationException;
import com.example.designpatterns.util.RetryPolicy;

public class RetryNotifierDecorator extends NotifierDecorator {
    private final RetryPolicy retryPolicy;

    public RetryNotifierDecorator(Notifier delegate, RetryPolicy retryPolicy) {
        super(delegate);
        this.retryPolicy = retryPolicy;
    }

    @Override
    public void send(String recipient, String message) throws NotificationException {
        try {
            retryPolicy.execute(() -> {
                try {
                    delegate.send(recipient, message);
                    return Boolean.TRUE;
                } catch (NotificationException ne) {
                    throw new RuntimeException(ne);
                }
            });
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof NotificationException) throw (NotificationException) cause;
            throw new NotificationException("Failed after retries", e);
        } catch (Exception ex) {
            throw new NotificationException("Failed after retries", ex);
        }
    }
}
