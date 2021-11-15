package com.example.fisioshop.controllers;

import com.example.fisioshop.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private com.example.fisioshop.repositories.OrderRepository OrderRepository;

    @PostMapping("/addO")
    public String addOrder(@RequestParam String name, @RequestParam Float totalprice) {
        Order Order = new Order();
        Order.setName(name);
        Order.settotalPrice(totalprice);
        OrderRepository.save(Order);
        return "Added new order to repo!";
    }

    @GetMapping("/listO")
    public Iterable<Order> getOrders() {
        return OrderRepository.findAll();
    }

    @GetMapping("/findO/{id}")
    public Order findOrderById(@PathVariable Integer id) {
        return OrderRepository.findOrderById(id);
    }
}