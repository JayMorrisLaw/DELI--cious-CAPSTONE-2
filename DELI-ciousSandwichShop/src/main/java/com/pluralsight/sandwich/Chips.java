package com.pluralsight.sandwich;

public class Chips {
    private String type;
    // attribute for type
// constructor
    public Chips(String type) {
        this.type = type;
    }// method
    public double getPrice(){
        return 1.50;
    }// method
    public String getType(){
        return type;
    }// method for getting price
    public String getReceiptLine() {
        return type + " - $" + String.format("%.2f", getPrice());// returns in this format
    }
}
