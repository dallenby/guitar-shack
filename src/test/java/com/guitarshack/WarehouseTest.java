package com.guitarshack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WarehouseTest {

    @Test
    public void getAProduct() {
        Warehouse warehouse = new ProductWarehouse(new Api<>("https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product", Product.class));
        Product product = warehouse.getProduct(811);
        assertThat(product.getId(), equalTo(811));
    }
}