package com.example.designpatterns.util;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public final class RetryPolicy {
    private final int maxAttempts;
    private final long initialBackoffMillis;

    public RetryPolicy(int maxAttempts, long initialBackoffMillis) {
        if (maxAttempts < 1) throw new IllegalArgumentException("maxAttempts >=1 required");
        if (initialBackoffMillis < 1) throw new IllegalArgumentException("initialBackoffMillis >=1 required");
        this.maxAttempts = maxAttempts;
        this.initialBackoffMillis = initialBackoffMillis;
    }

    public <T> T execute(Supplier<T> action) throws Exception {
        Objects.requireNonNull(action, "action");
        int attempt = 0;
        long backoff = initialBackoffMillis;
        while (true) {
            attempt++;
            try {
                return action.get();
            } catch (RuntimeException | Error e) {
                if (attempt >= maxAttempts) throw e;
                try {
                    TimeUnit.MILLISECONDS.sleep(backoff);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupted during retry backoff", ie);
                }
                backoff *= 2;
            }
        }
    }
}
