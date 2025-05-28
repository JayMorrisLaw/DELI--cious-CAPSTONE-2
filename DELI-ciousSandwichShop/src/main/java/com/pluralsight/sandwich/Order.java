package com.pluralsight.sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static void saveToFile(Order order) {
        //write to receipt
        try {
            // Format time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = "receipts.txt" + order.getOrderTime().format(formatter) + ".txt";

            //  write to receipt file
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            writer.write("=== DELI-cious Receipt ===\n");
            writer.write("Order ID: " + order.getOrderId() + "\n");
            writer.write("Time: " + order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            writer.write("--- Sandwiches ---\n");
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(sandwich.getPrice() + "\n");
            }

            writer.write("\n--- Drinks ---\n");
            for (Drinks drink : order.getDrinks()) {
                writer.write(drink.getSize() + " " + drink.getFlavor() + " - $" + String.format("%.2f", drink.getPrice()) + "\n");
            }

            writer.write("\n--- Chips ---\n");
            for (Chips chip : order.getChips()) {
                writer.write(chip.getType() + " - $" + String.format("%.2f", chip.getPrice()) + "\n");
            }


            writer.write("\nTOTAL: $" + String.format("%.2f", order.getTotal()) + "\n");
            writer.write("===========================\n");

            writer.close();
            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }

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
        return orderTime;}
    }


