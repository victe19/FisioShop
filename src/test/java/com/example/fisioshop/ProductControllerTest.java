package com.example.fisioshop;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {
    ProdController prodC = new ProdController();

    @Test
    void addProductTest(){
        //WITH PRODUCT
        String result = prodC.addProduct("Crema", 24.50);
        assertEquals("Crema", result);

        //WITHOUT PRODUCT
        String result2 = prodC.addProduct("", 10.00);
        assertEquals("", result2);
    }

    void getProductsTest(){
        ArrayList<Product> expected = this.getListOfProducts();

        ArrayList<Product> result = prodC.getProducts();

        //assertEquals(result, expected);

        assertEquals(expected.size(), result.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(expected.get(i).getName().toString(), result.get(i).getName().toString());
        }
    }

    private ArrayList<Product> getListOfProducts(){
        ArrayList<Product> products = new ArrayList<>();

        Product product = new Product("Masaje 1", 20.95, "Masaje Facial");
        products.add(product);

        product = new Product("Masaje 2", 30.95, "Masaje Corporal");
        products.add(product);

        product = new Product("Masaje 2", 50.95, "Masaje Completo");
        products.add(product);

        return products;
    }
}
