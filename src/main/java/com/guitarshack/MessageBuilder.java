package com.guitarshack;

public class MessageBuilder {


    public String build(Product product) {
        return String.format("Please order more of product %s, ", product.getId());
    }
}
