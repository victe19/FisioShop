package com.example.fisioshop.controllers;

import com.example.fisioshop.models.Customer;
import com.example.fisioshop.models.Order;
import com.example.fisioshop.models.Product;
import com.example.fisioshop.repositories.OrderService;
import com.example.fisioshop.repositories.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class OrderController {

    @Autowired
    private com.example.fisioshop.repositories.OrderRepository OrderRepository;
    private OrderService orderService;

    public OrderController(OrderService orderService) {
    }

    public void initOrdersController(){
        orderService.initOrders();
    }

    @PostMapping("/addO")
    public String addOrder(@RequestParam String name, @RequestParam double totalprice, @RequestParam Customer customer, @RequestParam ArrayList<Product> products) {
        String result = "";
        if (name.length()< 2 || name.length() > 12){
            if(name.length() < 2){
                result += "AQUEST ORDER HA DE TENIR UN NOM DE MÍNIM 2 CARÀCTERS";
            }else return "AQUEST ORDER HA DE TENIR UN NOM DE MÀXIM 12 CARÀCTERS";
        }
        if (!name.contains("[a-zA-Z]+")){
            result +="AQUEST PRODUCTE HA DE CONTENIR UN NOM DE MÍNIM UNA LLETRA";
        }
        //CONDICIONS NAME CUSTOMER
        if (totalprice == 0.0){
            result +="AQUEST ORDER HA DE TENIR UN PREU TOTAL SUPERIOR A 0";
        }
        //CONDICIONS NOM I COGNOM CUSTOMER
        if (Objects.equals(customer.getFirstName(), "")){
            result +="AQUEST ORDER HA DE TENIR UN NOM DE CUSTOMER";
        }

        if (Objects.equals(customer.getLastName(), "")){
            result +="QUEST ORDER HA DE TENIR UN COGNOM DE CUSTOMER";
        }
        if (!result.equals("")){
            return result;
        }
        Order Order = new Order();
        Order.setName(name);
        Order.settotalPrice(totalprice);
        Order.setCustomer_id(customer);
        Order.setProducts(products);

        OrderRepository.save(Order);
        return "AQUEST ORDER S'HA CREAT CORRECTAMENT";
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
