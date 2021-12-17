package com.guitarshack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductSalesHistory implements SalesHistory {
    private final Api<Sales> api;

    public ProductSalesHistory(Api<Sales> api) {
        this.api = api;
    }

    @Override
    public int total(int productId, LocalDate startDate, LocalDate endDate) {
        Sales sales = api.get(buildQueryString(productId, startDate, endDate));
        if(sales != null) return sales.total();
        return -1;
    }

    private String buildQueryString(int productId, LocalDate startDate, LocalDate endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        Object[] params = {productId, startDate.format(formatter), endDate.format(formatter), "total"};
        return String.format("?productId=%s&startDate=%s&endDate=%s&action=%s", params);
    }
}
