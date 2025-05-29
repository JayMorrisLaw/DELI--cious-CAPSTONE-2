package com.pluralsight;
import com.pluralsight.sandwich.*;
import java.util.Scanner;
// class imports


public class UserInterface {
    private Scanner scanner;

    // constructor
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    // main menu loop
    public void showMainMenu() {
        boolean running = true;
// while running....
        while (running) {
            System.out.println("=== Welcome to DELI-cious ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
// 1 for new order , 0 to exit menu
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

    // build new order
    private void processNewOrder() {
        Order order = new Order();
        boolean ordering = true;
// boolean ordering is true so loop while ordering
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
                    // displays order cost  in 2 decimal format
                    System.out.println("Order Total: $" + String.format("%.2f", order.getTotal()));
                    System.out.print("Confirm and checkout? (y/n): ");
                    String confirm = scanner.nextLine();
                    //confirm order
                    if (confirm.equalsIgnoreCase("y")) {
                        Receipts.saveToFile(order);
                        System.out.println("Order completed and receipt saved!.. Coming right up!");
                        ordering = false;
                    } else {
                        System.out.println("Returning to order menu...");
                    }
                    break;
                case "0":
                    // cancel order
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
//selecting size
        int size = 0;
        while (size != 4 && size != 8 && size != 12) {
            System.out.print("Choose sandwich size (4 in, 8 in, 12 in): ");
            try {
                size = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                size = 0;
            }
        }

        System.out.println("Choose bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        String breadType = "White";
        String breadChoice = scanner.nextLine();
        switch (breadChoice) {
            case "1":
                breadType = "White";
                break;
            case "2":
                breadType = "Wheat";
                break;
            case "3":
                breadType = "Rye";
                break;
            case "4":
                breadType = "Wrap";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to White.");
        }
        Bread bread = new Bread(breadType);

        System.out.print("Do you want it toasted? (y/n): ");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("y");

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
            String input = scanner.nextLine();

            switch (input) {
                case "1": { // meat switch cases using string splitter by a comma
                    boolean choosing = true;
                    while (choosing) {
                        System.out.println("Choose meat(s), separated by commas:");
                        System.out.println("1) Steak");
                        System.out.println("2) Ham");
                        System.out.println("3) Salami");
                        System.out.println("4) Roast Beef");
                        System.out.println("5) Chicken");
                        System.out.println("6) Bacon");
                        System.out.print("Enter choices or 0 to go back: ");
                        String inputMeat = scanner.nextLine();

                        if (inputMeat.equals("0")) {
                            choosing = false;
                            break;
                        }

                        String[] selections = inputMeat.split(",");
                        for (String choice : selections) {
                            choice = choice.trim();
                            String meatName = null;
                            switch (choice) {
                                case "1":
                                    meatName = "Steak";
                                    break;
                                case "2":
                                    meatName = "Ham";
                                    break;
                                case "3":
                                    meatName = "Salami";
                                    break;
                                case "4":
                                    meatName = "Roast Beef";
                                    break;
                                case "5":
                                    meatName = "Chicken";
                                    break;
                                case "6":
                                    meatName = "Bacon";
                                    break;
                                default:
                                    System.out.println("Invalid meat choice: " + choice);
                            }
                            if (meatName != null) {
                                boolean extra = askExtra();
                                sandwich.addTopping(new Meat(meatName), extra);
                            }
                        }
                        choosing = false;
                    }
                    break;
                }
                case "2": { // cheeese switch cases using string splitter by a comma
                    boolean choosing = true;
                    String cheeseName;
                    while (choosing) {
                        System.out.println("Choose cheese(s), separated by commas:");
                        System.out.println("1) American");
                        System.out.println("2) Provolone");
                        System.out.println("3) Cheddar");
                        System.out.println("4) Swiss");
                        System.out.print("Enter choices or 0 to go back: ");
                        String inputCheese = scanner.nextLine();

                        if (inputCheese.equals("0")) {
                            choosing = false;
                            break;
                        }
                        String[] selections = inputCheese.split(",");
                        for (String choice : selections) {
                            choice = choice.trim();
                            cheeseName = null;
                            switch (choice) {
                                case "1":
                                    cheeseName = "American";
                                    break;
                                case "2":
                                    cheeseName = "Provolone";
                                    break;
                                case "3":
                                    cheeseName = "Cheddar";
                                    break;
                                case "4":
                                    cheeseName = "Swiss";
                                    break;
                                default:
                                    System.out.println("Invalid cheese choice: " + choice);
                            }

                            if (cheeseName != null) {
                                boolean extra = askExtra();
                                sandwich.addTopping(new Cheese(cheeseName), extra);
                            }
                        }
                        choosing = false;
                    }
                    break;
                }
                case "3": { // regular topping switch cases using string splitter by a comma
                    boolean choosing = true;
                    while (choosing) {
                        System.out.println("Choose regular topping(s), separated by commas:");
                        System.out.println("1) Lettuce");
                        System.out.println("2) Tomato");
                        System.out.println("3) Onion");
                        System.out.println("4) Pickle");
                        System.out.println("5) Jalapeño");
                        System.out.println("6) Mushroom");
                        System.out.println("7) Cucumber");
                        System.out.println("8) Peppers");
                        System.out.println("9) Guac");
                        System.out.print("Enter choices or 0 to go back: ");
                        String inputToppings = scanner.nextLine();

                        if (inputToppings.equals("0")) {
                            choosing = false;
                            break;
                        }

                        String[] selections = inputToppings.split(",");
                        for (String choice : selections) {
                            choice = choice.trim();
                            String toppingName = null;

                            switch (choice) {
                                case "1":
                                    toppingName = "Lettuce";
                                    break;
                                case "2":
                                    toppingName = "Tomato";
                                    break;
                                case "3":
                                    toppingName = "Onion";
                                    break;
                                case "4":
                                    toppingName = "Pickle";
                                    break;
                                case "5":
                                    toppingName = "Jalapeño";
                                    break;
                                case "6":
                                    toppingName = "Mushroom";
                                    break;
                                case "7":
                                    toppingName = "Cucumber";
                                    break;
                                case "8":
                                    toppingName = "Peppers";
                                    break;
                                case "9":
                                    toppingName = "Guac";
                                    break;
                                default:
                                    System.out.println("Invalid topping: " + choice);
                            }

                            if (toppingName != null) {
                                sandwich.addTopping(new RegularTopping(toppingName), false);
                            }
                        }
                        choosing = false;
                    }
                    break;
                }

                case "4": {  // sauces switch case using string spliiter with comma
                    boolean choosing = true;
                    while (choosing) {
                        System.out.println("Choose sauce(s), separated by commas:");
                        System.out.println("1) Mayo");
                        System.out.println("2) Ketchup");
                        System.out.println("3) Ranch");
                        System.out.println("4) Thousand Island");
                        System.out.println("5) Vinaigrette");
                        System.out.print("Enter choices or 0 to go back: ");
                        String inputSauces = scanner.nextLine();

                        if (inputSauces.equals("0")) {
                            choosing = false;
                            break;
                        }
                        String[] selections = inputSauces.split(",");
                        for (String choice : selections) {
                            choice = choice.trim();
                            String sauceName = null;

                            switch (choice) {
                                case "1":
                                    sauceName = "Mayo";
                                    break;
                                case "2":
                                    sauceName = "Ketchup";
                                    break;
                                case "3":
                                    sauceName = "Ranch";
                                    break;
                                case "4":
                                    sauceName = "Thousand Island";
                                    break;
                                case "5":
                                    sauceName = "Vinaigrette";
                                    break;
                                default:
                                    System.out.println("Invalid sauce: " + choice);
                            }

                            if (sauceName != null) {
                                sandwich.addTopping(new Sauce(sauceName), false);
                            }
                        }
                        choosing = false;
                    }
                    break;
                }

                case "0":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added!\n");
    }


    private void processAddDrink(Order order) {
        String size = "";
        while (size.equals("")) {
            System.out.println("Choose drink size:");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");
            System.out.print("Choice: ");
            String sizeChoice = scanner.nextLine();

            switch (sizeChoice) {
                case "1":
                    size = "Small";
                    break;
                case "2":
                    size = "Medium";
                    break;
                case "3":
                    size = "Large";
                    break;
                default:
                    System.out.println("Invalid size. Please select 1, 2, or 3.");
            }
            System.out.println("Drink added! ");
        }

        String flavor = "";
        while (flavor.equals("")) {
            System.out.println("Choose drink flavor:");
            System.out.println("1) Cola");
            System.out.println("2) Lemonade");
            System.out.println("3) Sprite");
            System.out.println("4) Orange Soda");
            System.out.println("5) Dr. Pepper");
            System.out.print("Choice: ");
            String flavorChoice = scanner.nextLine();

            switch (flavorChoice) {
                case "1":
                    flavor = "Cola";
                    break;
                case "2":
                    flavor = "Lemonade";
                    break;
                case "3":
                    flavor = "Sprite";
                    break;
                case "4":
                    flavor = "Orange";
                    break;
                case "5":
                    flavor = "Dr. Pepper";
                    break;
                default:
                    System.out.println("Invalid flavor. Please choose from the list.");
            }
        }

        order.addDrink(new Drinks(size, flavor));
        System.out.println("Drink added.\n");
    }

    private void processAddChips(Order order) {
        boolean choosing = true;
        while (choosing) {
            System.out.println("Choose chip(s), separated by commas:");
            System.out.println("1) BBQ");
            System.out.println("2) Jalapeño Kettle");
            System.out.println("3) Sour Cream & Onion");
            System.out.println("4) Plain Potato Chips");
            System.out.println("5) Honey Sriracha");
            System.out.print("Enter choices or 0 to go back: ");
            String chipInput = scanner.nextLine();

            if (chipInput.equals("0")) {
                choosing = false;
                break;
            }
            String[] selections = chipInput.split(",");
            for (String choice : selections) {
                choice = choice.trim();
                String chipType = null;

                switch (choice) {
                    case "1":
                        chipType = "BBQ";
                        break;
                    case "2":
                        chipType = "Jalapeño Kettle";
                        break;
                    case "3":
                        chipType = "Sour Cream & Onion";
                        break;
                    case "4":
                        chipType = "Plain";
                        break;
                    case "5":
                        chipType = "Honey Sriracha";
                        break;
                    default:
                        System.out.println("Invalid chip type: " + choice);
                }

                if (chipType != null) {
                    order.addChips(new Chips(chipType));
                }
            }
            choosing = false;
            break;
        }
    }

    private boolean askExtra() {
        String userInput;
        while (true) {
            boolean asking = true;
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("y")){
                return true;
            } else if (userInput.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("invalid input");
            }


        }
    }
}
