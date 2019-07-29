package com.foodorder.orderservice.service;

import com.foodorder.orderservice.model.Food;
import com.foodorder.orderservice.model.Order;
import com.foodorder.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TableService tableService;

    @Autowired
    private FoodService foodService;

    public Order saveOrder(Order order) {
        checkIfTableFromOrderExist(order);
        return orderRepository.save(insertFoodToOrder(order));
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    private void checkIfTableFromOrderExist(Order order) {
        if(!tableService.checkIfTableExist(order.getTable().getNumber())) {
            throw new RuntimeException();
        }
    }

    private Order insertFoodToOrder(Order order) {
        //TODO
        order.getFood().forEach(foodService.getFoodByName(order.getFood()));
        return order;
    }
}
