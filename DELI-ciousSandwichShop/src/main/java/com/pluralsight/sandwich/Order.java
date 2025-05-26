package com.pluralsight.sandwich;

import com.pluralsight.Chips;
import com.pluralsight.Drinks;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private static int nextId = 1;

    private int orderId;
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drinks> drinks;
    private ArrayList<Chips> chips;
    private LocalDateTime orderTime;

    public Order() {
        this.orderId = nextId++;  // Assign and increment
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drinks drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double getTotal() {
        double total = 0.0;

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
