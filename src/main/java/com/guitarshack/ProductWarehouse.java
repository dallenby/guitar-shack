package com.guitarshack;

public class ProductWarehouse implements Warehouse {
    private final Api<Product> api;

    public ProductWarehouse(Api<Product> api) {
        this.api = api;
    }

    @Override
    public Product getProduct(int id) {
        return api.get("?id=" + id);
    }
}
