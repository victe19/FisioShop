package com.example.fisioshop;

import com.example.fisioshop.controllers.OrderController;
import com.example.fisioshop.models.Customer;
import com.example.fisioshop.models.Product;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderControllerTest {

    @Mock
    com.example.fisioshop.repositories.OrderService OrderService;

    OrderController orderC = new OrderController(OrderService);

    ArrayList<Product> products = null;
    Customer customer1 = new Customer("Victor", "Arauzo");
    Customer customer2 = new Customer("Victor", "");
    Customer customer3 = new Customer("", "");

    @BeforeEach
    void init(){
        for (int i = 0; i < 3; i++) {
            assert false;
            products.add(new Product("product" + i, 10.00, "test Order"));
        }
    }
    /*
    Utilitzem sis casos de paràmetres per obtenir les diferentes particions equivalents.
            CASOS:
            - happy path: tipus i valors correctes.
            - sad path: posem limitacions als atributs de Order:
                · name: entre 2 i 12, mínim una lletra
                . total price: no 0.0
                . customer: nom i cognom
    */
    @Test
    public void addOrderTest(){

        //CASOS HAPPY PATH
        String result1 = orderC.addOrder("Order 1", 100.00, customer1, products); //HAPPY PATH

        //CASOS SAD PATH
        String result2 = orderC.addOrder("Order 2", 0.0, customer2, products); //SAD PATH PRICE I CUSTOMER

        String result3 = orderC.addOrder("1234", 10.20, customer3, products); //SAD PATH NAME 1 I CUSTOMER
        String result4 = orderC.addOrder("a", 10.20, customer1, products); //SAD PATH NAME 2
        String result5 = orderC.addOrder("qwertyuiopasdf", 10.20, customer1, products); //SAD PATH NAME 3

        assertEquals("AQUEST ORDER S'HA CREAT CORRECTAMENT", result1);
        assertEquals("AQUEST ORDER HA DE TENIR UN PREU SUPERIOR A 0 AQUEST ORDER HA DE TENIR UN NOM DE CUSTOMER", result2);
        assertEquals("AQUEST ORDER HA DE CONTENIR UN NOM DE MÍNIM UNA LLETRA AQUEST ORDER HA DE TENIR UN COGNOM DE CUSTOMER", result3);
        assertEquals("AQUEST ORDER HA DE TENIR UN NOM DE MÍNIM 2 CARÀCTERS", result4);
        assertEquals("AQUEST ORDER HA DE TENIR UN NOM DE MÀXIM 12 CARÀCTERS", result5);
    }
}
