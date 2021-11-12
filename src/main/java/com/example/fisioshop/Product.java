package com.example.fisioshop;


import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Double price;
    private String description;

    public Product() {

    }

    public Product(String name, Double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }


    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String name) {
        this.name = name;
    }



    String name_expected1 = "test1";
    String name_expected2 = "test2";
    String name_expected3 = "test3";
    String name_expected4 = "test4";

}
