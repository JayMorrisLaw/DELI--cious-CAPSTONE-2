package com.pluralsight;

public class Meat extends Topping {

    public Meat(String name) {
        super(name); // Calls the constructor from Topping
    }

    @Override
    public double getPrice(int size, boolean isExtra) {
        // We'll write this part next
        return 0.0; // Placeholder for now
    }

}
