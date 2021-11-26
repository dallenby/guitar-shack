package com.guitarshack;

public class Product {
    private final int id;
    private final int stock;

    public Product(int id, int stock) {

        this.id = id;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }
}
