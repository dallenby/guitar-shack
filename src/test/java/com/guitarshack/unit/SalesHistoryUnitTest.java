package com.guitarshack.unit;

import com.guitarshack.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalesHistoryUnitTest extends AbstractSalesHistoryTest {
    @Override
    protected SalesHistory createSalesHistory() {
        Api<SalesTotal> api = (Api<SalesTotal>) mock(Api.class);
        when(api.get(any())).thenReturn(new SalesTotal(16));
        return new ProductSalesHistory(api);
    }
}
