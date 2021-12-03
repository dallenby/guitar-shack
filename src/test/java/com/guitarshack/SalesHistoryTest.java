package com.guitarshack;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SalesHistoryTest {

    @Test
    public void getTotalSales(){
        SalesHistory salesHistory = new ProductSalesHistory(new Api("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales", SalesTotal.class));
        assertThat(salesHistory.total(811, LocalDate.of(2020, Month.JULY, 17), LocalDate.of(2020, Month.JULY, 27)), equalTo(16));
    }
}
