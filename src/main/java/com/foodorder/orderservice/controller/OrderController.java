package com.foodorder.orderservice.controller;

import com.foodorder.orderservice.model.Order;
import com.foodorder.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> getOrdersByDate(
            @RequestParam(value = "dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dateFrom,
            @RequestParam(value = "dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dateTo) {
        return new ResponseEntity<>(orderService.getOrdersByDate(dateFrom, dateTo), HttpStatus.OK);
    }

    @PostMapping(value = "/orders")
    public ResponseEntity saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
