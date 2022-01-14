package com.guitarshack.unit;

import com.guitarshack.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalesHistoryUnitTest extends AbstractSalesHistoryTest {
    @Override
    protected SalesHistory createSalesHistory() {
        Api<Sales> api = mock(WebApi.class);
        when(api.get(any())).thenReturn(new Sales(16));
        return new ProductSalesHistory(api);
    }

    @Test
    public void shouldReturnMinusOneWhenNoSalesTotalReturned(){
        Api<Sales> api = mock(WebApi.class);
        when(api.get(any())).thenReturn(null);
        ProductSalesHistory productSalesHistory = new ProductSalesHistory(api);
        assertThat(productSalesHistory.total(811, LocalDate.now(), LocalDate.now()), equalTo(-1));
    }
}
