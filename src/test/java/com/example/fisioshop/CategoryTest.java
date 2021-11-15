package com.example.fisioshop;

import com.example.fisioshop.models.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

    /*
     TEST per comprovar funcionalitat del constructor:
         Analitzar si els camps s'afegeixen correctament a l'objecte
     */
    @Test
    void ConstructorTest(){
        //OBJECTS
        Category category1 = new Category("categoryName_test");

        String name_expected1 = "categoryName_test";


        //ASSERTS
        assertEquals("Nom correcte", name_expected1, category1.getName());
    }
}