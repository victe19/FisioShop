package com.example.fisioshop.models;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;

    @ManyToOne(optional = false)
    private Order order_ids;

    public Customer(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    public Customer() {

    }

    public Order getOrder_ids() {
        return order_ids;
    }

    public void setOrder_ids(Order order_ids) {
        this.order_ids = order_ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}