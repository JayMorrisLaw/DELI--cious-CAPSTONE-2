package com.pluralsight;

import com.pluralsight.sandwich.Order;
import com.pluralsight.sandwich.Sandwich;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Receipts {
    public static void saveToFile(Order order) {// method for saving to file
        try {
            File folder = new File("receipts.csv");
            folder.mkdirs();
// write to / append receipts.csv file
            String fileName = "receipts.csv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
// header
            writer.write("=== DELI-cious Receipt ===\n");
            writer.write("Order ID: " + order.getOrderId() + "\n");
            writer.write("Time: " + order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");
// write sandwiches
            writer.write("--- Sandwiches ---\n");
            int i = 1;
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(i++ + ") " + sandwich.getReceiptLine() + "\n");
            }
// writing drinks using a lambda expression,
            writer.write("\n--- Drinks ---\n");
            order.getDrinks().forEach(drink -> writeSafe(writer, drink.getReceiptLine()));
// for each drink in the drink list write the receipt line

// write chips using lambda  for each orde of chips write recepit line
            writer.write("\n--- Chips ---\n");
            order.getChips().forEach(chip -> writeSafe(writer, chip.getReceiptLine()));

// write total , using 2 decimal formatting
            writer.write("\nTOTAL: $" + String.format("%.2f", order.getTotal()) + "\n");
            writer.write("===========================\n");
// close writer 
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    private static void writeSafe(BufferedWriter writer, String line) {
        try {
            writer.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Error writing line: " + e.getMessage());
        }
    }
}
