package com.guitarshack;

import java.time.LocalDate;
import java.time.Month;

public class ReorderCheckerBuilder {
    public ReorderChecker build() {
        Reorder reorder = new ReorderProduct();

        return new ReorderChecker(
            new ProductWarehouse(
                new WebApi<>("https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product",
                        Product.class
                )
            ),
            new LeadTimeReorderThreshold(
                new ThirtyDayAverage(
                    new ProductSalesHistory(
                        new WebApi<>("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales",
                            Sales.class)
                    ),
                    () -> LocalDate.of(2021, Month.DECEMBER, 1)
                )
            ),
            reorder
        );
    }
}
