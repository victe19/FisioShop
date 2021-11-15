package com.example.fisioshop;

import com.example.fisioshop.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    /*
     TEST per comprovar funcionalitat del constructor:
         Analitzar si els camps s'afegeixen correctament a l'objecte
     */
    @Test
    void ConstructorTest(){
        //OBJECTS
        Product product1 = new Product("test1", 10.10, "descTest1");

        String name_expected1 = "test1";
        Double price_expected1 = 10.10;
        String desc_expected1 = "descTest1";

        //ASSERTS
        assertEquals("Nom correcte", name_expected1, product1.getName());
        assertEquals("Preu correcte", price_expected1, product1.getPrice());
        assertEquals("Descripció correcte", desc_expected1, product1.getDescription());






    }

}
