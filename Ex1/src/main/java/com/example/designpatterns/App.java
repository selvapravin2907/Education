package com.example.designpatterns;

import com.example.designpatterns.logging.AppLogger;
import com.example.designpatterns.behavioral.observer.*;
import com.example.designpatterns.behavioral.strategy.*;
import com.example.designpatterns.creational.factory.*;
import com.example.designpatterns.creational.builder.Recipe;
import com.example.designpatterns.structural.adapter.*;
import com.example.designpatterns.structural.decorator.DecoratorDemo;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class App {
    private static final Logger LOG = AppLogger.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        LOG.info("Design Patterns Demo starting...");
        CountDownLatch done = new CountDownLatch(1);

        Thread console = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            printHelp();
            while (true) {
                System.out.print("cmd> ");
                String line = sc.nextLine();
                if (line == null) continue;
                String cmd = line.trim().toLowerCase();
                try {
                    switch (cmd) {
                        case "help": printHelp(); break;
                        case "observer": runObserverDemo(); break;
                        case "strategy": runStrategyDemo(); break;
                        case "factory": runFactoryDemo(); break;
                        case "builder": runBuilderDemo(); break;
                        case "adapter": runAdapterDemo(); break;
                        case "decorator": DecoratorDemo.runDemo(); break;
                        case "exit": done.countDown(); sc.close(); return;
                        default: System.out.println("unknown command. type 'help'");
                    }
                } catch (Exception e) {
                    LOG.warning(() -> "Command failed: " + e.getMessage());
                }
            }
        }, "Console-Thread");

        console.setDaemon(false);
        console.start();
        done.await();
        LOG.info("Shutting down demo app");
    }

    private static void printHelp() {
        System.out.println("Available commands: help, observer, strategy, factory, builder, adapter, decorator, exit");
    }

    private static void runObserverDemo() {
        StockMarket market = new StockMarket();
        Trader t1 = new Trader("Alice", 100.0);
        Trader t2 = new Trader("Bob", 50.0);
        AnalyticsDashboard dash = new AnalyticsDashboard();

        market.registerObserver(t1);
        market.registerObserver(t2);
        market.registerObserver(dash);

        market.setPrice("AAPL", 120.5);
        market.setPrice("AAPL", 48.9);
    }

    private static void runStrategyDemo() {
        Order order = new Order();
        order.addItem("Pizza", 8.99);
        order.addItem("Pasta", 6.49);

        PricingEngine engine = new PricingEngine(new NoDiscountStrategy());
        System.out.printf("No discount final: %.2f\n", engine.computeFinalPrice(order));

        engine.setStrategy(new PercentageDiscountStrategy(0.15));
        System.out.printf("15%% discount final: %.2f\n", engine.computeFinalPrice(order));
    }

    private static void runFactoryDemo() throws NotificationException {
        Notifier n1 = NotifierFactory.create("email");
        Notifier n2 = NotifierFactory.create("sms");
        n1.send("alice@example.com", "Factory pattern demo - email");
        n2.send("+911234567890", "Factory pattern demo - sms");
    }

    private static void runBuilderDemo() {
        Recipe r = new Recipe.Builder("Masala Dosa")
                .addIngredient("Rice")
                .addIngredient("Urad dal")
                .addStep("Soak and grind")
                .addStep("Ferment batter")
                .chef("Chef Raju")
                .prepMinutes(45)
                .videoUrl("https://example.com/dosa.mp4")
                .build();
        System.out.println("Built recipe: " + r.title() + " by " + r.chef());
    }

    private static void runAdapterDemo() {
        LegacyPaymentProcessor legacy = new LegacyPaymentProcessor();
        NewPaymentGateway gateway = new PaymentAdapter(legacy);
        boolean ok = gateway.charge("4111-1111-1111-1111", 19.99);
        System.out.println("Payment ok: " + ok);
    }
}
