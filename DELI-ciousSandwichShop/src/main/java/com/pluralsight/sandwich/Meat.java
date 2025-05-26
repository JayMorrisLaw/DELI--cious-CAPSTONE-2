package com.pluralsight.sandwich;

public class Meat extends Topping {

    public Meat(String name) {
        super(name); // Calls the constructor from Topping
    }
    @Override
    public double getPrice(int size, boolean isExtra) {
        // setting base and extra price
        double basePrice = 0.0;
        double extraPrice = 0.0;
// checking to see if the size matches the price with if/else if statement
        if (size == 4) {
            basePrice = 1.00;
            extraPrice = 0.50;
        } else if (size == 8) {
            basePrice = 2.00;
            extraPrice = 1.00;
        } else if (size == 12) {
            basePrice = 3.00;
            extraPrice = 1.50;
        }

        return isExtra ? basePrice + extraPrice : basePrice;
    }


}
