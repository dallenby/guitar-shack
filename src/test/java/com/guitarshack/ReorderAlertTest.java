package com.guitarshack;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ReorderAlertTest {

    @Test
    public void productDoesNotNeedReordering() {
        ReorderAlert reorderAlert = mock(ReorderAlert.class);
        Warehouse warehouse = id -> new Product(811, 22);
        ReorderThreshold reorderThreshold = product -> 18;
        ReorderChecker reorderChecker = new ReorderChecker(warehouse, reorderThreshold, reorderAlert);
        reorderChecker.onSale(811, 3);

        verify(reorderAlert, never()).alert();
    }

    @Test
    public void productDoesNeedReordering(){
        ReorderAlert reorderAlert = mock(ReorderAlert.class);
        Warehouse warehouse = id -> new Product(811,10);
        ReorderThreshold reorderThreshold = product -> 8;
        ReorderChecker reorderChecker = new ReorderChecker(warehouse, reorderThreshold, reorderAlert);
        reorderChecker.onSale(811, 3);

        verify(reorderAlert).alert();
    }
}
