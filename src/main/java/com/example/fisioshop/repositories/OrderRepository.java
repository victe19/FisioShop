package com.example.fisioshop.repositories;

import com.example.fisioshop.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    Order findOrderById(Integer id);
}