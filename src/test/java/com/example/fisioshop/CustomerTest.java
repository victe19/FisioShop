package com.example.fisioshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    /*
    TEST per comprovar funcionalitat del constructor:
        Analitzar si els camps s'afegeixen correctament a l'objecte
    */
    @Test
    void ConstructorTest(){
        //OBJECTS
        Customer customer1 = new Customer("Carlos","Lopez");

        String name_expected1 = "Carlos";
        String last_expected1 = "Lopez";

        //ASSERTS
        assertEquals("Nom erroni", customer1.getFirstName(), name_expected1);
        assertEquals("Cognom erroni", customer1.getLastName(), last_expected1);

    }

}

