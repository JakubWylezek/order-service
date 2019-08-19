package com.foodorder.orderservice.exception.custom;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Long orderId) {
        super("Such order with id " + orderId + " was not found");
    }
}
