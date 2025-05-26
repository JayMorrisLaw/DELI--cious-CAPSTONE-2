package com.pluralsight.sandwich;

public class Sauce extends Topping {

    public Sauce(String name){
        super(name);
    }
    @Override
    public double getPrice(int size,boolean isExtra){
        return 0.0; // sauce is always included
    }

}
