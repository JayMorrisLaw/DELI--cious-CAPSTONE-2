package com.pluralsight;

import com.pluralsight.sandwich.Order;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.ToppingPortion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Receipts {
    public static void saveToFile(Order order) {// method for saving to file
        try {
// write to / append receipts.txt file
            String fileName = "receipts.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
// header
            writer.write("=== DELI-cious Receipt ===\n");
            writer.write("Order ID: " + order.getOrderId() + "\n");
            writer.write("Time: " + order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");
// write sandwiches
            writer.write("--- Sandwiches ---\n");
            int i = 1;
            //loops through each sandwich in the order
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(i++ + ") " + sandwich.getReceiptLine() + "\n");
// shows each topping specifically and if its extra
                // looping through each topping object
                for (ToppingPortion tp : sandwich.getToppings()) {
                    // if topping is extra return extra
                    String extra = tp.isExtra() ? " (extra)" : "";
                    writer.write("    - " + tp.getTopping().getName() + extra + "\n");
                    // this line writes all toppings in a dash format and adds extra is its extra
                }
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
