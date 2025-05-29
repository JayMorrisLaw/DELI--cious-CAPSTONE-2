package com.pluralsight.sandwich;

public abstract class Topping {
    private String name;
// attribute ^ and constructor below
    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        // returns topping name
        return name;
    }

    // Subclasses will implement this method
    public abstract double getPrice(int size, boolean isExtra);
}
