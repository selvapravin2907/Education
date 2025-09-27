package com.example.designpatterns.behavioral.strategy;

import java.util.*;

public class Order {
    private final List<Item> items = new ArrayList<>();

    public static final class Item {
        public final String name;
        public final double price;
        public Item(String name, double price) {
            this.name = Objects.requireNonNull(name);
            if (price < 0) throw new IllegalArgumentException("price >=0");
            this.price = price;
        }
    }

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public double total() {
        return items.stream().mapToDouble(i -> i.price).sum();
    }

    public List<Item> items() { return Collections.unmodifiableList(items); }
}
