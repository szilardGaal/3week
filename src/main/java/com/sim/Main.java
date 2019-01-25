package com.sim;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Ui ui = new Ui(inventory);
        while (true) {
            ui.printMainMenu();
        }
    }
}
