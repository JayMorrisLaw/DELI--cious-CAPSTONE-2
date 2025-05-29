package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // passes scanner through ui to read console input

        UserInterface ui = new UserInterface(scanner);
        ui.showMainMenu(); //  Launch the main UI loop
        scanner.close();
    }
}
