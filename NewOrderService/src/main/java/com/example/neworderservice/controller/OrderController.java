package com.example.neworderservice.controller;

import com.example.neworderservice.entity.OrderRequestObject;
import com.example.neworderservice.entity.OrderResponseObject;
import com.example.neworderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
curl --location --request POST 'http://localhost:9192/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "order" : {"name" : "pragya",
    "qty" : 100,
    "price" : 101
    },
    "payment" : {

    }
}'*/

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    public static final String CIRCUIT_BREAKER_NAME = "circuitBreaker";

    @PostMapping("/order")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "dispalyFailureMessage")
    public OrderResponseObject placeOrder(@RequestBody OrderRequestObject order){
        orderService.handleorderPlacement(order);
        return new OrderResponseObject(order.getOrder().getId());
    }

    public OrderResponseObject dispalyFailureMessage(Exception e){
        return  new OrderResponseObject(99999L);
    }
}
