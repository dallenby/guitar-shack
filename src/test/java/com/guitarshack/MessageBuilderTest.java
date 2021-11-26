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
        Product product = new Product(811, 10);
        message = messageBuilder.build(product);
    }

    @Test
    public void messageContainsProductId() {
        assertThat(message, containsString("Please order more of product 811, "));
    }
}
