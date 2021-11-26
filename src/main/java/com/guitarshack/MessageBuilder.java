package com.guitarshack;

public class MessageBuilder {

    public String build(Product product) {
        return String.format("Please order more of product %s, %s. Minimum order is %s, available rack space is %s.",
                product.getId(),
                product.getDescription(),
                product.getMinimumOrder(),
                product.getRackSpace()
        );
    }
}
