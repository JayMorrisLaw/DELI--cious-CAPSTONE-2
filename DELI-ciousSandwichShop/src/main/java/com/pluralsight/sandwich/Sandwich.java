package com.pluralsight.sandwich;

import java.util.ArrayList;
import java.util.List;


public class Sandwich {
    //attributes to sandwich class
    private int  size;
    private Bread breadType;
    private boolean isToasted;
    private List<ToppingPortion> toppings;

    //constructor

    public Sandwich(int size, Bread bread, boolean isToasted) {
        this.size = size;
        this.breadType = bread;
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
//  initialize price ^
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

// generates a line summary of the sandwich
    public String getReceiptLine() {
        StringBuilder line = new StringBuilder();
        // builds string
        line.append(size).append("\" ");
        // shows size
        line.append(breadType.getType());
        // shows bread type

        if (isToasted) {
            line.append(" (toasted)");
        }

        line.append(" - $").append(String.format("%.2f", getPrice()));
        return line.toString();
        // shows price
    }
    public List<ToppingPortion> getToppings() {
        return toppings;
    }


}

