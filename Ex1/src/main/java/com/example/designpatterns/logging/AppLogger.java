package com.example.designpatterns.logging;

import java.io.IOException;
import java.util.logging.*;

public final class AppLogger {
    private static final Logger root = Logger.getLogger("com.example.designpatterns");

    static {
        try {
            root.setUseParentHandlers(false);
            Handler console = new ConsoleHandler();
            console.setLevel(Level.INFO);
            root.addHandler(console);

            Handler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.FINE);
            root.addHandler(fileHandler);

            root.setLevel(Level.FINE);
        } catch (IOException e) {
            System.err.println("Failed to initialize file logger: " + e.getMessage());
        }
    }

    private AppLogger() {}

    public static Logger getLogger(Class<?> cls) {
        return Logger.getLogger(cls.getName());
    }
}
