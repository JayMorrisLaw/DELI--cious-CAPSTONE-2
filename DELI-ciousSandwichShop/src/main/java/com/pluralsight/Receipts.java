package com.pluralsight;

import com.pluralsight.sandwich.Order;
import com.pluralsight.sandwich.Sandwich;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Receipts {
    public static void saveToFile(Order order) {
        try {
            File folder = new File("receipts");
            folder.mkdirs();

            String fileName = "receipts/" + order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("=== DELI-cious Receipt ===\n");
            writer.write("Order ID: " + order.getOrderId() + "\n");
            writer.write("Time: " + order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            writer.write("--- Sandwiches ---\n");
            int i = 1;
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(i++ + ") " + sandwich.getReceiptLine() + "\n");
            }

            writer.write("\n--- Drinks ---\n");
            order.getDrinks().forEach(drink -> writeSafe(writer,
                    drink.getSize() + " " + drink.getFlavor() + " - $" + String.format("%.2f", drink.getPrice())
            ));

            writer.write("\n--- Chips ---\n");
            order.getChips().forEach(chip -> writeSafe(writer,
                    chip.getType() + " - $" + String.format("%.2f", chip.getPrice())
            ));

            writer.write("\nTOTAL: $" + String.format("%.2f", order.getTotal()) + "\n");
            writer.write("===========================\n");

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
