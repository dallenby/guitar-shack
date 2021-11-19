package com.guitarshack;

public class ReorderChecker {
    private final Warehouse warehouse;
    private final ReorderThreshold reorderThreshold;
    private final ReorderAlert reorderAlert;

    public ReorderChecker(Warehouse warehouse, ReorderThreshold reorderThreshold, ReorderAlert reorderAlert) {
        this.warehouse = warehouse;
        this.reorderThreshold = reorderThreshold;
        this.reorderAlert = reorderAlert;
    }

    public void onSale(int productId, int quantity) {
        Product product = warehouse.getProduct(productId);
        Boolean reorder = (product.getStock() - quantity) < reorderThreshold.calculate(product);
        if(reorder) reorderAlert.alert();
    }
}
