package com.guitarshack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReorderThresholdTest {

    @Test
    public void calculateReorderThreshold(){
        SalesPerDay salesPerDay = product -> 1.5;
        ReorderThreshold reorderThreshold = new LeadTimeReorderThreshold(salesPerDay);
        Product product = new Product(0, 0, "", 0, 0, 19);
        assertThat(reorderThreshold.calculate(product), equalTo(28.5));
    }
}
