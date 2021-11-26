package com.guitarshack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class MessageBuilderTest {

    private String message;

    @Before
    public void setup() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Product product = new Product(811, 10, "Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst", 20, 30, 20);
        message = messageBuilder.build(product);
    }

    @Test
    public void messageContainsProductId() {
        assertThat(message, containsString("Please order more of product 811, "));
    }

    @Test
    public void messageContainsProductDescription() {
        assertThat(message, containsString("Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst. "));
    }

    @Test
    public void messageContainsMinimumOrderAmount() {
        assertThat(message, containsString("Minimum order is 20, "));
    }

    @Test
    public void messageContainsRackSpace() {
        assertThat(message, containsString("available rack space is 30."));
    }
}
