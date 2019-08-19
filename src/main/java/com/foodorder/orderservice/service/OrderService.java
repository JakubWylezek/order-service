package com.foodorder.orderservice.service;

import com.foodorder.orderservice.exception.custom.OrderNotFoundException;
import com.foodorder.orderservice.model.Order;
import com.foodorder.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TableService tableService;

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> getOrdersByDate(LocalDate dateFrom, LocalDate dateTo) {
        return orderRepository.getOrdersByOrderDateBetween(dateFrom, dateTo);
    }

    public void saveOrder(Order order) {
        checkIfTableFromOrderExist(order);
        orderRepository.save(setDateToOrder(order));
    }

    private void checkIfTableFromOrderExist(Order order) {
        if(!tableService.checkIfTableExist(order.getTable().getNumber())) {
            throw new RuntimeException();
        }
    }

    private Order setDateToOrder(Order order) {
        order.setOrderDate(LocalDate.now());
        return order;
    }
}
