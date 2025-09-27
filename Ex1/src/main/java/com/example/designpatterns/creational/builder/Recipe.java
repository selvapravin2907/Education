package com.example.designpatterns.creational.builder;

import java.util.*;

public final class Recipe {
    private final String title;
    private final List<String> ingredients;
    private final List<String> steps;
    private final String chef;
    private final int prepMinutes;
    private final Optional<String> videoUrl;

    private Recipe(Builder b) {
        this.title = b.title;
        this.ingredients = Collections.unmodifiableList(new ArrayList<>(b.ingredients));
        this.steps = Collections.unmodifiableList(new ArrayList<>(b.steps));
        this.chef = b.chef;
        this.prepMinutes = b.prepMinutes;
        this.videoUrl = Optional.ofNullable(b.videoUrl);
    }

    public String title() { return title; }
    public List<String> ingredients() { return ingredients; }
    public List<String> steps() { return steps; }
    public String chef() { return chef; }
    public int prepMinutes() { return prepMinutes; }
    public Optional<String> videoUrl() { return videoUrl; }

    public static class Builder {
        private final String title;
        private final List<String> ingredients = new ArrayList<>();
        private final List<String> steps = new ArrayList<>();
        private String chef = "unknown";
        private int prepMinutes = 0;
        private String videoUrl = null;

        public Builder(String title) {
            if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title");
            this.title = title;
        }

        public Builder addIngredient(String ing) { if (ing == null || ing.trim().isEmpty()) throw new IllegalArgumentException("ing"); ingredients.add(ing); return this; }
        public Builder addStep(String step) { if (step == null || step.trim().isEmpty()) throw new IllegalArgumentException("step"); steps.add(step); return this; }
        public Builder chef(String chef) { this.chef = Objects.requireNonNull(chef); return this; }
        public Builder prepMinutes(int m) { if (m < 0) throw new IllegalArgumentException("prepMinutes"); this.prepMinutes = m; return this; }
        public Builder videoUrl(String url) { this.videoUrl = url; return this; }

        public Recipe build() { return new Recipe(this); }
    }
}
