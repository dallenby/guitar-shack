package com.guitarshack;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;


@RunWith(JUnitParamsRunner.class)
public class ReorderTest {

    @Test
    public void productDoesNotNeedReordering() {
        Reorder reorder = mock(Reorder.class);
        Warehouse warehouse = id -> new Product(811, 22, "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst", 20, 30);
        ReorderThreshold reorderThreshold = product -> 18;
        ReorderChecker reorderChecker = new ReorderChecker(warehouse, reorderThreshold, reorder);
        reorderChecker.onSale(811, 3);

        verify(reorder, never()).alert();
    }

    @Test
    @Parameters({"3", "2"})
    public void productDoesNeedReordering(int quantity) {
        Reorder reorder = mock(Reorder.class);
        Warehouse warehouse = id -> new Product(811, 10, "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst", 20, 30);
        ReorderThreshold reorderThreshold = product -> 8;
        ReorderChecker reorderChecker = new ReorderChecker(warehouse, reorderThreshold, reorder);
        reorderChecker.onSale(811, quantity);

        verify(reorder).alert();
    }

    @Test
    public void productHasAlreadyBeenReordered() {
        Reorder reorder = mock(Reorder.class);
        Warehouse warehouse = id -> new Product(811, 10, "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst", 20, 30);
        ReorderThreshold reorderThreshold = product -> 18;
        ReorderChecker reorderChecker = new ReorderChecker(warehouse, reorderThreshold, reorder);
        reorderChecker.onSale(811, 3);

        verify(reorder, never()).alert();
    }
}
