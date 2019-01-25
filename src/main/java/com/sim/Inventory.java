package com.sim;

import java.util.Set;
import java.util.HashMap;


public class Inventory {

    private Item[] items;
    private HashMap<String, double[]> invReport = new HashMap<String, double[]>();

    public Inventory() {
        this.items = new Item[0];
    }

    public Item[] getItems() {
        return this.items;
    }

    public HashMap<String, double[]> getItemsList() {
        return this.invReport;
    }

    public Item findItemByName(String name) {
        for (Item item : items) {
            if (item.getFullItemName().toLowerCase().contains(name.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public Item[] getItemOnSale() {
        Item[] itemsOnSale = new Item[0];
        for (Item item : items) {
            if (item.isOnSale()) {
                itemsOnSale = Utility.addToArray(itemsOnSale, item);
            }
        }
        return itemsOnSale;
    }

    public Item[] getAvaiableItems() {
        Item[] itemAvaiable = new Item[0];
        for (Item item : items) {
            if (item.getAvaiability()) {
                itemAvaiable = Utility.addToArray(itemAvaiable, item);
            }
        }
        return itemAvaiable;
    }

    public void addItemToInventory(Item item) {
        items = Utility.addToArray(items, item);
        String itemName = item.getFullItemName();
        
        if (!invReport.containsKey(itemName)) {
            double[] numbers = {item.getStockValue(), 1};
            invReport.put(itemName, numbers);
        } else {
            double averagePrice = item.getSellValue()/invReport.get(itemName)[0];
            double quantity = invReport.get(itemName)[1]+1;
            double[] numbers = {averagePrice, quantity};
            invReport.put(itemName, numbers);
        }
    }

    public Set<String> getLabels() {
        String[] allLabels = new String[0];
        for (Item item : items) {
            for (String label : item.getLabels()) {
                allLabels = Utility.addToArray(allLabels, label);
            }
        }
        Set<String> labelSet = Set.of(allLabels);
        return labelSet;
    }
}