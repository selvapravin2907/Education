package com.example.designpatterns.creational.factory;

import java.util.Objects;

public final class NotifierFactory {
    private NotifierFactory() {}

    public static Notifier create(String type) {
        Objects.requireNonNull(type);
        switch (type.toLowerCase()) {
            case "email": return new EmailNotifier();
            case "sms": return new SmsNotifier();
            default: throw new IllegalArgumentException("Unknown notifier type: " + type);
        }
    }
}
