package com.example.fisioshop;

import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class OrderTest {
    /*
     TEST per comprovar funcionalitat del constructor:
         Analitzar si els camps s'afegeixen correctament a l'objecte
     */
    @Test
    void ConstructorTest(){
        //OBJECTS
        Customer customer1 = new Customer("Victor", "Arauzo");
        Order order1 = new Order("order1", 100.0, customer1);

        String name_expected1 = "test1";
        Double price_expected1 = 10.10;
        String desc_expected1 = "descTest1";

        //ASSERTS
        assertEquals("Nom correcte", name_expected1, product1.getName());
        assertEquals("Preu correcte", price_expected1, product1.getPrice());
        assertEquals("Descripció correcte", desc_expected1, product1.getDescription());
}
