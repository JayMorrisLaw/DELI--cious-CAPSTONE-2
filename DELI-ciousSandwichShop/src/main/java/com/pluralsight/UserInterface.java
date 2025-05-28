package com.pluralsight;
import com.pluralsight.sandwich.*;
import java.util.Scanner;
import com.pluralsight.Receipts;


public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("=== Welcome to DELI-cious ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processNewOrder();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void processNewOrder() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    processAddSandwich(order);
                    break;
                case "2":
                    processAddDrink(order);
                    break;
                case "3":
                    processAddChips(order);
                    break;
                case "4":
                    System.out.println("Order Total: $" + String.format("%.2f", order.getTotal()));
                    System.out.print("Confirm and checkout? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        Receipts.saveToFile(order);
                        System.out.println("Order completed and receipt saved!.. Coming right up!");
                        ordering = false;
                    } else {
                        System.out.println("Returning to order menu...");
                    }
                    break;
                case "0":
                    System.out.println("Order canceled. Returning home.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void processAddSandwich(Order order) {
        System.out.println("--- Build Your Sandwich ---");

        int size = 0;
        while (size != 4 && size != 8 && size != 12) {
            System.out.print("Choose sandwich size (4 in, 8 in, 12 in): ");
            try {
                size = Integer.parseInt(this.scanner.nextLine());
            } catch (NumberFormatException e) {
                size = 0;
            }
        }

        System.out.println("Choose bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        String breadChoice = this.scanner.nextLine();
        String breadType = switch (breadChoice) {
            case "1" -> "White";
            case "2" -> "Wheat";
            case "3" -> "Rye";
            case "4" -> "Wrap";
            default -> "White";
        };
        Bread bread = new Bread(breadType);

        System.out.print("Do you want it toasted? (y/n): ");
        boolean isToasted = this.scanner.nextLine().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, bread, isToasted);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("\nAdd a topping:");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular Topping");
            System.out.println("4) Sauce");
            System.out.println("0) Done");
            System.out.print("Choice: ");
            String input = this.scanner.nextLine();

            switch (input) {
                case "1" -> {
                    System.out.print("Enter meat (e.g., Ham): ");
                    String name = this.scanner.nextLine();
                    boolean extra = askExtra();
                    sandwich.addTopping(new Meat(name), extra);
                }
                case "2" -> {
                    System.out.print("Enter cheese (e.g., Swiss): ");
                    String name = this.scanner.nextLine();
                    boolean extra = askExtra();
                    sandwich.addTopping(new Cheese(name), extra);
                }
                case "3" -> {
                    System.out.print("Enter regular topping (e.g., Lettuce): ");
                    String name = this.scanner.nextLine();
                    sandwich.addTopping(new RegularTopping(name), false);
                }
                case "4" -> {
                    System.out.print("Enter sauce (e.g., Mayo): ");
                    String name = this.scanner.nextLine();
                    sandwich.addTopping(new Sauce(name), false);
                }
                case "0" -> addingToppings = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added!\n");
    }


    private void processAddDrink(Order order) {
        System.out.println("Choose drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        String sizeChoice = this.scanner.nextLine();
        String size = switch (sizeChoice) {
            case "1" -> "Small";
            case "2" -> "Medium";
            case "3" -> "Large";
            default -> "Small";
        };

        System.out.print("Enter drink flavor (e.g., Cola): ");
        String flavor = this.scanner.nextLine();

        order.addDrink(new Drinks(size, flavor));
        System.out.println("Drink added.\n");
    }

    private void processAddChips(Order order) {
        System.out.print("Enter chip type (e.g., BBQ): ");
        String type = this.scanner.nextLine();

        order.addChips(new Chips(type));
        System.out.println("Chips added.\n");
    }

    private boolean askExtra() {
        System.out.print("Would you like extra for an upcharge? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

}
