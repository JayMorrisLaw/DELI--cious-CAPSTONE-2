package com.pluralsight;

import com.pluralsight.sandwich.Order;
import com.pluralsight.sandwich.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Receipts {

    public static void saveToFile(Order order) {
        try {
            // Format time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = "receipts.csv" + order.getOrderTime().format(formatter) + ".txt";

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
}