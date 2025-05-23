package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



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

    // methods for add topping ang get price
    public void addTopping(Topping topping, boolean extra) {
        toppings.add(new ToppingPortion(topping, extra));
    }
    public double getPrice(){
        // TODO: Implement real pricing later using size, bread type, and toppings
        return 0.0; // placeholder value so your program compiles
    }
}

