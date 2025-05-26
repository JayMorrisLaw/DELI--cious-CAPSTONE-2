package com.pluralsight.sandwich;

import java.util.ArrayList;


public class Sandwich {
    //attributes to sandwich class
    private int size;
    private String breadType;
    private boolean isToasted;
    private ArrayList<ToppingPortion> toppings;


    //constructor

    public Sandwich(int size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    // methods for add topping and get price
    public void addTopping(Topping topping, boolean extra) {
        toppings.add(new ToppingPortion(topping, extra));
    }
    public double getPrice(){
        // determining price
        double basePrice = 0.0;
        if (size ==4) {
            basePrice = 5.50;
        } else if (size == 8) {
            basePrice = 7.00;
        }else if (size == 12){
            basePrice = 8.50;
        }
       // add topping prices

        for (ToppingPortion portion : toppings) {
            basePrice += portion.getTopping().getPrice(size, portion.isExtra());

        }
        return basePrice;
    }
}

