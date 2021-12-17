package com.guitarshack;

import java.time.LocalDate;

public class ThirtyDayAverage implements SalesPerDay {
    private static final int DATE_RANGE = 30;
    private final SalesHistory salesHistory;
    private final Today today;

    public ThirtyDayAverage(SalesHistory salesHistory, Today today) {
        this.salesHistory = salesHistory;
        this.today = today;
    }

    @Override
    public double of(Product product) {
        LocalDate endDate = today.getDate();
        LocalDate startDate = endDate.minusDays(DATE_RANGE);
        return (double) salesHistory.total(product.getId(), startDate, endDate) / (double) DATE_RANGE;
    }
}