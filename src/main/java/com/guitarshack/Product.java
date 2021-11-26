package com.guitarshack;

public class Product {
    private final int id;
    private final int stock;
    private final String description;
    private final int minimumOrder;
    private final int rackSpace;
    private final int leadTime;

    public Product(int id, int stock, String description, int minimumOrder, int rackSpace, int leadTime) {
        this.id = id;
        this.stock = stock;
        this.description = description;
        this.minimumOrder = minimumOrder;
        this.rackSpace = rackSpace;

        this.leadTime = leadTime;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getMinimumOrder() {
        return minimumOrder;
    }

    public int getRackSpace() {
        return rackSpace;
    }

    public int getLeadTime() {
        return leadTime;
    }
}
