package com.pluralsight.sandwich;

import com.pluralsight.Chips;
import com.pluralsight.Drinks;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    // attributes
    private static int nextId = 1;// order tracking, starts at1 and + by1
    private int orderId;
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drinks> drinks;
    private ArrayList<Chips> chips;
    private LocalDateTime orderTime;

    public Order() {
        // constructor
        this.orderId = nextId++;  // Assigns ID and increments
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public int getOrderId() {
        return orderId;
    }
// methods
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drinks drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }
// calculate total cost
    public double getTotal() {
        double total = 0.0;// initialize total
// getting prices for all items
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }

        for (Drinks drink : drinks) {
            total += drink.getPrice();
        }

        for (Chips chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }
// returning fields
    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drinks> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
}
