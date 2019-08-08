package com.example.menu2;

import java.io.Serializable;

public class canteen implements Serializable {
    private int serial;
    private String items;
    private String description;
    private String price;
    private String quantity;
    private int image;

    public canteen(int serial,String items, String description,String price, String quantity, int image) {
        this.serial = serial;
        this.items = items;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

