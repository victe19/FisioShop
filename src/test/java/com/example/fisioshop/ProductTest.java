package com.example.fisioshop;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    Product product;


    //TEST CONTROLLER
    @BeforeEach
    public void setup(){
        product = new Product("Masaje", 29.95);

    }

    @Test
    void addProductTest(String name, Double price)
    {

    }

    //TEST MODEL
}
