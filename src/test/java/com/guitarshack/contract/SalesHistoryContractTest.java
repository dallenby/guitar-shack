package com.guitarshack.contract;

import com.guitarshack.*;

public class SalesHistoryContractTest extends AbstractSalesHistoryTest {

    @Override
    protected SalesHistory createSalesHistory() {
        return new ProductSalesHistory(new Api<>("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales", Sales.class));
    }

}