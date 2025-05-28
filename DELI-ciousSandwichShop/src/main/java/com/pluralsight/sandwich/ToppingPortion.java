package com.pluralsight.sandwich;

public class ToppingPortion {
    private Topping topping;
    private boolean extra;
// topping and if its extra
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
