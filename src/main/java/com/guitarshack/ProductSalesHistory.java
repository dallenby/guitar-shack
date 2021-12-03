package com.guitarshack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductSalesHistory implements SalesHistory {

    private final Api<SalesTotal> api;

    public ProductSalesHistory(Api<SalesTotal> api) {
        this.api = api;
    }

    @Override
    public int total(int productId, LocalDate startDate, LocalDate endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        Object[] params = {productId, startDate.format(formatter), endDate.format(formatter), "total"};
        String queryString = String.format("?productId=%s&startDate=%s&endDate=%s&action=%s", params);

        SalesTotal salesTotal = api.get(queryString);
        if(salesTotal != null) return salesTotal.getTotal();
        return -1;
    }
}
