package com.pluralsight.sandwich;

import com.pluralsight.UserInterface;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);
        ui.showMainMenu(); //  Launch the main UI loop
    }
}
