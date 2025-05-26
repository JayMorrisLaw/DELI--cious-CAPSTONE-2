package com.pluralsight.sandwich;

public class RegularTopping extends Topping {

    public RegularTopping(String name){
        super(name);
    }
    @Override
    public double getPrice(int size,boolean isExtra){
        return 0.0; // toppings and sauces are always free so return 0
    }
}
