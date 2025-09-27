package com.example.designpatterns.structural.decorator;

import com.example.designpatterns.creational.factory.Notifier;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier delegate;

    protected NotifierDecorator(Notifier delegate) {
        this.delegate = delegate;
    }
}
