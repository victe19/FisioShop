package com.example.fisioshop.models;

import com.example.fisioshop.models.Customer;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Float totalPrice;

    @ManyToOne
    private Customer customer_id;

    public Order(String name, float totalprice, Customer customer1) {
        this.name = name;
        this.totalPrice = totalprice;
        this.customer_id = customer1;

    }

    public Order() {

    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float gettotalPrice() { return totalPrice; }

    public void settotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}