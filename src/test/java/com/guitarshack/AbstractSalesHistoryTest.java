package com.guitarshack;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class AbstractSalesHistoryTest {
    protected abstract SalesHistory createSalesHistory();

    @Test
    public void getTotalSales() {
        SalesHistory salesHistory = createSalesHistory();
        assertThat(salesHistory.total(811, LocalDate.of(2020, Month.JULY, 17), LocalDate.of(2020, Month.JULY, 27)), equalTo(16));
    }
}
