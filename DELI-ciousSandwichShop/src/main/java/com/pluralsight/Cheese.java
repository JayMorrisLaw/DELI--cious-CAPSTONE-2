package com.pluralsight;

public class Cheese extends Topping{

    public Cheese (String name){
        super(name);
    }
    @Override
    public double getPrice(int size, boolean isExtra) {
        // setting base and extra price
        double basePrice = 0.0;
        double extraPrice = 0.0;
// checking size to price ratio
        if (size == 4) {
            basePrice = 0.75;
            extraPrice = 0.30;
        } else if (size == 8) {
            basePrice = 1.50;
            extraPrice = 0.60;
        } else if (size == 12) {
            basePrice = 2.25;
            extraPrice = 0.90;
        }

        return isExtra ? basePrice + extraPrice : basePrice;
    }

}

