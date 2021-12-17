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
        double threshold = reorderThreshold.calculate(product);
        if (!onOrder(product, threshold) && needsReordering(quantity, product, threshold)) {
            reorder.alert(new MessageBuilder().build(product));
        }
    }

    private boolean needsReordering(int quantity, Product product, double threshold) {
        return (product.getStock() - quantity) <= threshold;
    }

    private boolean onOrder(Product product, double threshold) {
        return product.getStock() <= threshold;
    }
}
