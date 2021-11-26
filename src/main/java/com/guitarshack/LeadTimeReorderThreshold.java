package com.guitarshack;

public class LeadTimeReorderThreshold implements ReorderThreshold {

    private final SalesPerDay salesPerDay;
    public LeadTimeReorderThreshold(SalesPerDay salesPerDay) {
        this.salesPerDay = salesPerDay;
    }

    @Override
    public double calculate(Product product) {

        return product.getLeadTime() * salesPerDay.of(product);
    }
}
