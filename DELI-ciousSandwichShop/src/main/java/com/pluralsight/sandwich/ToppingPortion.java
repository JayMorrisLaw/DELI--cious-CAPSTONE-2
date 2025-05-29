package com.pluralsight.sandwich;
// wrapper class that presents a portion size and if its regular
public class ToppingPortion {
    private Topping topping;
    private boolean extra;
    // attributes^
// constructor
    public ToppingPortion(Topping topping, boolean extra) {
        this.topping = topping;
        this.extra = extra;
    }
// methods for get topping and if its extra
    public Topping getTopping() {
        return topping;
    }

    public boolean isExtra() {
        return extra;
    }
}
