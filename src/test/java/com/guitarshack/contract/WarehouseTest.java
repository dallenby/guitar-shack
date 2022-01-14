package com.guitarshack.contract;

import com.guitarshack.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WarehouseTest {

    private static Product product;

    @BeforeClass
    public static void setup() {
        Warehouse warehouse = new ProductWarehouse(new WebApi<>("https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product", Product.class));
        product = warehouse.getProduct(811);
    }

    @Test
    public void getProductId() {
        assertThat(product.getId(), equalTo(811));
    }

    @Test
    public void getProductStock(){
        assertThat(product.getStock(), greaterThan(0));
    }

    @Test
    public void getProductDescription(){
        assertThat(product.getDescription(), is(not(equalTo(""))));
    }

    @Test
    public void getMinOrder(){
        assertThat(product.getMinOrder(), greaterThan(0));
    }

    @Test
    public void getRackspace() {
        assertThat(product.getRackspace(), greaterThan(0));
    }

    @Test
    public void getLeadTime(){
        assertThat(product.getLeadTime(), greaterThan(0));
    }
}