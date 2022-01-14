package com.guitarshack;

public class Product {
    private final int id;
    private final int stock;
    private final String description;
    private final int minOrder;
    private final int rackspace;
    private final int leadTime;

    public Product(int id, int stock, String description, int minOrder, int rackspace, int leadTime) {
        this.id = id;
        this.stock = stock;
        this.description = description;
        this.minOrder = minOrder;
        this.rackspace = rackspace;
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

    public int getMinOrder() {
        return minOrder;
    }

    public int getRackspace() {
        return rackspace;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public boolean needsReordering(int quantity, double threshold) {
        return (getStock() - quantity) <= threshold;
    }

    public boolean onOrder(double threshold) {
        return getStock() <= threshold;
    }
}
