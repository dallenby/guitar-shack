package com.guitarshack;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SalesPerDayTest {

    @Test
    public void calculatesSalesPerDay(){
        Product product = new Product(0, 0, "", 0,0,0);
        SalesHistory salesHistory = (productId, startDate, endDate) -> 15;
        SalesPerDay salesPerDay = new ThirtyDayAverage(salesHistory);
        assertThat(salesPerDay.of(product), equalTo(0.5));
    }
}
