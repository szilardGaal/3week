package com.sim;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;

public class Ui {
    
    private Scanner sc = new Scanner(System.in);
    private Inventory inventory;

    private final String mainMenu = "Main Menu\n=========";
    private final String buyItem = "Buy\n===";
    private final String sellItem = "Sell\n====";
    private final String inventoryMenu = "Inventory\n=========";
    
    private String[] mainMenuTitles = {"Buy items", "Sell items", "Search Inventory"};
    private String[] buyTitles = {"New incoming invoice", "Buy history"};
    private String[] sellTitles = {"New invoice", "Sell history"};
    private String[] inventoryMenuTitles = {"Search", "List all items", "List all labels", "List all items by label"};


    public Ui(Inventory inventory) {
        this.inventory = inventory;
    }

    public void printMainMenu() {
        printMenu(mainMenu, mainMenuTitles);}

    private void printMenu(String menu, String[] menuTitles) {
        clearTerminal();
        System.out.println(menu);
        for (int i=0; i < menuTitles.length; i++) {
            System.out.println(i+1 + ". --> " + menuTitles[i]);
        }
        System.out.println("");
        if (!menu.equals(mainMenu)) {
            System.out.println("r. --> Return to main menu");
        }
        System.out.println("x. --> Exit program");
        switch (menu) {
            case mainMenu: 
                selectMainMenu();
                break;
            case buyItem:
                selectBuyMenu();
                break;
            case sellItem:
                selectSellMenu();
                break;
            case inventoryMenu:
                selectinventoryMenu();
                break;
        }
    }

    private void selectMainMenu() {
        String userInput = sc.nextLine();
        switch (userInput) {
            case "1":
                printMenu(buyItem, buyTitles);
                break;
            case "2":
                printMenu(sellItem, sellTitles);
                break;
            case "3":
                printMenu(inventoryMenu, inventoryMenuTitles);
                break;
            case "x":
                System.exit(1);
        }
    }

    private void selectBuyMenu() {
        String userInput = sc.nextLine();
        switch (userInput) {
            case "1":
                buyItem();
                break;
            case "r":
                printMainMenu();
                break;
            case "x":
                System.exit(1);
            default:
                printMenu(buyItem, buyTitles);
        }
    }

    private void selectSellMenu() {
        String userInput = sc.nextLine();
        switch (userInput) {
            case "r":
                printMainMenu();
                break;
            case "x":
                System.exit(1);
            default:
                printMenu(sellItem, sellTitles);
        }
    }

    private void selectinventoryMenu() {
        String userInput = sc.nextLine();
        switch (userInput) {
            case "2":
                displayAllItems();
                break;
            case "r":
                printMainMenu();
                break;
            case "x":
                System.exit(1);
                break;
            default:
                printMenu(inventoryMenu, inventoryMenuTitles);
        }
    }

    private void clearTerminal() {
        System.out.println("\033[H\033[2J");
    }

    private void buyItem() {
        String[] attributeTitles = {"manufacturer", "name", "price", "labels", "quantity"};
        int lengthOfAttributes = attributeTitles.length;
        String[] attributes = new String[lengthOfAttributes];

        for (int i=0; i < lengthOfAttributes; i++) {
            System.out.println("Please give the items " + attributeTitles[i] + ": ");
            attributes[i] = sc.nextLine();
        }
        
        try {
            String[] labels = attributes[3].split(",");
            int quantity = Integer.parseInt(attributes[4]);
            int price = Integer.parseInt(attributes[2]);

            for (int i=0; i< quantity; i++) {
                inventory.addItemToInventory(new Item(attributes[0], attributes[1], price, labels));
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input!");
            pressEnterToContinue();
        }        
    }

    private void displayAllItems(){
        for (String name : inventory.getItemsList().keySet()) {
            System.out.println(name + " " + Arrays.toString(inventory.getItemsList().get(name)));
        }
    }

    private void pressEnterToContinue() {
        System.out.println("\nPress \"ENTER\" to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}