package com.example.fisioshop.models;

import com.example.fisioshop.models.Customer;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private double totalPrice;

    @OneToMany
    private ArrayList<Product> product_ids;

    @ManyToOne
    private Customer customer_id;

    public Order(String name, double totalprice, Customer customer1, ArrayList<Product> products) {
        this.name = name;
        this.totalPrice = totalprice;
        this.customer_id = customer1;
        this.product_ids = products;

    }

    public Order() {
    }

    public ArrayList<Product> getProducts() {
        return product_ids;
    }

    public void setProducts(ArrayList<Product> products) {
        this.product_ids = products;
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

    public double gettotalPrice() { return totalPrice; }

    public void settotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String calculateTotalPrice(){
        for (Product product_id : this.product_ids) {
            this.totalPrice += product_id.getPrice();
        }
        return "El preu total és de " + this.totalPrice;
    }


}