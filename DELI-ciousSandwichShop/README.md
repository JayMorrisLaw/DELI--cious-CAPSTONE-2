# DELI-cious Ordering System

## Overview

DELI-cious is a command-line point-of-sale (POS) system written in Java that simulates the experience of placing an order at a sandwich deli. 
Customers can create custom sandwiches, add drinks and chips, and receive a detailed printed receipt.

This capstone demonstrates core Java programming skills, including object-oriented design, file I/O, and user interaction through the console.

## Features

### Interactive Order Flow

- Welcome menu with options to start a new order or exit
- Interactive submenus for:
    - Adding sandwiches
    - Adding drinks
    - Adding chips
    - Checking out or canceling

### Custom Sandwich Builder

- Choose sandwich size: 4", 8", or 12"
- Select bread: White, Wheat, Rye, or Wrap
- Option to toast the bread
- Add unlimited toppings from four categories:
    - Meats (Steak, Ham, Chicken, etc.)
    - Cheeses (Provolone, Swiss, Cheddar, etc.)
    - Regular toppings (Lettuce, Tomato, Pickles, etc.)
    - Sauces (Mayo, Ranch, Vinaigrette, etc.)
- Option for "extra" portions of meats or cheeses, with additional cost

### Sides and Drinks

- Choose from three drink sizes: Small, Medium, Large
- Add chips by flavor: BBQ, Sour Cream & Onion, Jalapeño Kettle, etc.

### Receipt Generation

- Each completed order generates a `.txt` receipt file saved in a `/receipts/` directory
- Receipt includes:
    - Order ID and timestamp
    - Full sandwich breakdown with toppings and "extra" indicators
    - Drink and chip summaries
    - Total order cost

## Technologies Used

- Java 17+
- IntelliJ IDEA (or any Java IDE)
- Command-line input (Scanner)
- File I/O (BufferedWriter)
- Java collections (ArrayList)
- Optional use of lambda expressions

Jaden Morris-Law
Thankful for my teacher Raymond and his potato sensei help tool 


