package com.example.fisioshop;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    Order findOrderById(Integer id);
}