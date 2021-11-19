package com.guitarshack;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ReorderAlertTest {

    @Test
    public void productDoesNotNeedReordering() {
        ReorderAlert reorderAlert = Mockito.mock(ReorderAlert.class);
        Warehouse warehouse = id -> new Product(811, 22);
        ReorderThreshold reorderThreshold = product -> 18;
        ReorderChecker reorderChecker = new ReorderChecker(warehouse, reorderThreshold, reorderAlert);
        reorderChecker.onSale(811, 3);
        verify(reorderAlert, never()).alert();
    }
}
