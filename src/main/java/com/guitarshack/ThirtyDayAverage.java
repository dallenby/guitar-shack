package com.guitarshack;

import java.time.LocalDate;

public class ThirtyDayAverage implements SalesPerDay {
    private final SalesHistory salesHistory;
    private final Today today;

    public ThirtyDayAverage(SalesHistory salesHistory, Today today) {
        this.salesHistory = salesHistory;
        this.today = today;
    }

    @Override
    public double of(Product product) {
        LocalDate saleDate = today.getDate();
        return (double) salesHistory.total(product.getId(), saleDate.minusDays(30), saleDate) / 30.0;
    }
}