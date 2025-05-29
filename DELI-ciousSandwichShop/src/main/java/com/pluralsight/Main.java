package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // passes scanner through ui
        UserInterface ui = new UserInterface(scanner);
        ui.showMainMenu(); //  Launch the main UI loop
    }
}
