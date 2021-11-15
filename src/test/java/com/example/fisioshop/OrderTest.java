package com.example.fisioshop;

import com.example.fisioshop.models.Customer;
import com.example.fisioshop.models.Order;
import com.example.fisioshop.models.Product;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class OrderTest {

    Customer customer1;
    ArrayList<Product> products = null;
    /*
     TEST per comprovar funcionalitat del constructor:
         Analitzar si els camps s'afegeixen correctament a l'objecte
     */
    @BeforeEach
    void init(){
        Customer customer1 = new Customer("Victor", "Arauzo");
        for (int i = 0; i < 3; i++) {
            assert false;
            products.add(new Product("product" + i, 10.00, "test Order"));
        }
    }
    @Test
    public void ConstructorTest() {
        //OBJECTS

        Order order1 = new Order("order1", 100.0, customer1, products);

        String name_expected1 = "test1";
        Double price_expected1 = 10.10;
        String desc_expected1 = "descTest1";

        //ASSERTS
        assertEquals("Nom correcte", name_expected1, order1.getName());
        assertEquals("Preu correcte", price_expected1, order1.gettotalPrice());
        assertEquals("Customer correcte", customer1, order1.getCustomer_id());
        assertEquals("Productes correctes", products, order1.getProducts());
    }
    /*
    Test per comprovar funcionalitat de calcular el preu total
        Analitzar si suma bé els preus de cada producte i retorne un missatge satisfactori
     */
    @Test
    public void calculateTotalPriceTest(){
        Order order1 = new Order("order1", 0.0, customer1, products);
        String result = order1.calculateTotalPrice();

        assertEquals("El missatge és correcte", "El preu total és de 30.00", result);
        assertEquals("El preu és correcte", 30.00, order1.gettotalPrice());
    }
}
