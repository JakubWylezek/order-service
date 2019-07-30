package com.foodorder.orderservice.repository;

import com.foodorder.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getOrdersByOrderDateBetween(LocalDate dateFrom, LocalDate dateTo);
}
