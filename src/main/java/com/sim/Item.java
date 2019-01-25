package com.sim;

public class Item {
    
    private String manufacturer;
    private String name;
    private int price;
    private double sellPrice;
    private boolean onSale;
    private boolean inStore;
    private String[] labels;

    public Item(String manufacturer, String name, int price, String[] labels) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.sellPrice = Math.round(price * 1.2);
        this.labels = labels;
    }

    public String getItemName() {
        return this.name;
    }

    public String getFullItemName() {
        String labelString = "";
        for (String label : labels) {
            labelString += " " + label;
        }
        return this.name + " " + this.manufacturer;
    }

    public int getStockValue() {
        return this.price;
    }

    public double getSellValue() {
        return this.sellPrice;
    }

    public boolean isOnSale() {
        return this.onSale;
    }

    public boolean getAvaiability() {
        return this.inStore;
    }

    public String[] getLabels() {
        return this.labels;
    }

    public void itemOnSale(int percent) {
        this.onSale = true;
        this.sellPrice = sellPrice * (1 + percent/100);
    }
}