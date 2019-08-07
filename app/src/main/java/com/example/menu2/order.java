package com.example.menu2;

public class order {
    private String items;
    private String price;
    private String quantity;

    public order(String items, String price,String quantity) {
        this.items = items;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
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
}

