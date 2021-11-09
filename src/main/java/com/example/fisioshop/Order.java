package com.example.fisioshop;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Float totalPrice;

    @OneToMany(mappedBy = "order_ids")
    private Collection<Customer> customer_id;

    public Collection<Customer> getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Collection<Customer> customer_id) {
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
