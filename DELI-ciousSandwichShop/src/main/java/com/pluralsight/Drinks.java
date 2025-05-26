package com.pluralsight;

public class Drinks {
    private String size;
    private String flavor;
// constructor
    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    // setting prices
    public double getPrice() {
        if (size.equalsIgnoreCase("small")) {
            return 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("large"))
            return 3.00;
          else {
    return 0.0;
        }
    }
    //methods
    public String getSize(){
        return size;
    }
    public String getFlavor(){
        return flavor;
    }
}
