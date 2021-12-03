package com.guitarshack.unit;

import com.guitarshack.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class SalesPerDayTest {

    private SalesPerDay salesPerDay;
    private Product product;
    private SalesHistory salesHistory;

    @Before
    public void setup() {
        product = new Product(0, 0, "", 0,0,0);
        salesHistory = mock(SalesHistory.class);
        when(salesHistory.total(anyInt(), any(), any())).thenReturn(15);
        Today today = () -> LocalDate.of(2021, Month.NOVEMBER, 12);
        salesPerDay = new ThirtyDayAverage(salesHistory, today);
    }

    @Test
    public void calculatesSalesPerDay(){
        assertThat(salesPerDay.of(product), equalTo(0.5));
    }

    @Test
    public void startDate() {
        salesPerDay.of(product);
        verify(salesHistory).total(anyInt(), eq(LocalDate.of(2021, Month.OCTOBER, 13)), any());
    }

    @Test
    public void endDate() {
        salesPerDay.of(product);
        verify(salesHistory).total(anyInt(), any(), eq(LocalDate.of(2021, Month.NOVEMBER, 12)));
    }
}
