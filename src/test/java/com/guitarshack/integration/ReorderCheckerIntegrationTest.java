package com.guitarshack.integration;

import com.guitarshack.*;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ReorderCheckerIntegrationTest {
    @Test
    public void triggersReorderAlert() {
        Reorder reorder = Mockito.mock(Reorder.class);

        ReorderChecker reorderChecker = new ReorderChecker(
                new ProductWarehouse(
                        new Api<Product>(
                                "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product",
                                Product.class
                        )
                ),
                new LeadTimeReorderThreshold(
                        new ThirtyDayAverage(
                                new ProductSalesHistory(
                                        new Api<>(
                                                "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales",
                                                Sales.class
                                        )
                                ),
                                () -> LocalDate.of(2021, Month.DECEMBER,1)
                        )
                ),
                reorder
        );

        reorderChecker.onSale(811, 27);

        verify(reorder).alert(any());
    }
}
