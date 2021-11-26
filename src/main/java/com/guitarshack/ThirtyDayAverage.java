package com.guitarshack;

public class ThirtyDayAverage implements SalesPerDay {
    private final SalesHistory salesHistory;

    public ThirtyDayAverage(SalesHistory salesHistory) {

        this.salesHistory = salesHistory;
    }

    @Override
    public double of(Product product) {
        return Double.valueOf(salesHistory.total(product.getId(), null, null)) / Double.valueOf(30);
    }
}
