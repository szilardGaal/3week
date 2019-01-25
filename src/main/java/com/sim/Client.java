package com.sim;

public class Client {
    
    private String name;
    private int serial;

    public Client(String name, int serial) {
       this.name = name;
       this.serial = serial;
    }

    public String getName() {
        return this.name;
    }

    public int getSerial() {
        return this.serial;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    

}