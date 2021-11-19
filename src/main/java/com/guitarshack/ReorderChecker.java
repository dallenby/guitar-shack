package com.guitarshack;

public class ReorderChecker {
    private final Warehouse warehouse;
    private final ReorderThreshold reorderThreshold;
    private final Reorder reorder;

    public ReorderChecker(Warehouse warehouse, ReorderThreshold reorderThreshold, Reorder reorder) {
        this.warehouse = warehouse;
        this.reorderThreshold = reorderThreshold;
        this.reorder = reorder;
    }

    public void onSale(int productId, int quantity) {
        Product product = warehouse.getProduct(productId);
        Boolean reorder = (product.getStock() - quantity) <= reorderThreshold.calculate(product);
        if(reorder) this.reorder.alert();
    }
}
