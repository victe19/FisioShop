package com.example.fisioshop;

import com.example.fisioshop.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    ArrayList<Product> products_r1 = new ArrayList<>();
    ArrayList<Product> products_r2 = new ArrayList<>();
    //ArrayList<Product> products_r3 = new ArrayList<>();

    /*@BeforeAll
    void setUp(){

        for(int i=0; i<5;i++) {
            //if(i < 3){
            Product product = new Product("Masaje " + i, 10.20 * (i + 1), "descripcion producto " + i);
            products_r1.add(product);
            //}
            //Product product = new Product("Masaje " + i, 10.20 * (i + 1), "descripcion producto " + i);
            //products_r3.add(product);
        }
    }*/

    @Mock
    com.example.fisioshop.repositories.ProductService ProductService;

    ProdController prodC = new ProdController(ProductService);
    /*
    Utilitzem sis casos de paràmetres per obtenir les diferentes particions equivalents.
            CASOS:
            - happy path: tipus i valors correctes.
            - sad path: posem limitacions als atributs de Customere:
                · name: entre 2 i 12, mínim una lletra
                . price: no 0.0
                . description: entre 0 i 20
    */
    @Test
    void addProductTest(){
        //CASOS HAPPY PATH
        String result1 = prodC.addProduct("Masaje 1", 10.20, "Masaje"); //HAPPY PATH

        //CASOS SAD PATH
        String result2 = prodC.addProduct("Masaje 1", 0.0, "Masaje"); //SAD PATH PRICE

        String result3 = prodC.addProduct("1234", 10.20, "Masaje"); //SAD PATH NAME 1
        String result4 = prodC.addProduct("a", 10.20, "Masaje"); //SAD PATH NAME 2
        String result5 = prodC.addProduct("qwertyuiopasdf", 10.20, "Masaje"); //SAD PATH NAME 3

        String result6 = prodC.addProduct("Masaje 1", 10.20, "Aquesta descripció " +
                "té més de 20 caràcters i per tant falla"); //SAD PATH DESC 2

        assertEquals("AQUEST PRODUCTE S'HA CREAT CORRECTAMENT", result1);
        assertEquals("AQUEST PRODUCTE HA DE TENIR UN PREU SUPERIOR A 0", result2);
        assertEquals("AQUEST PRODUCTE HA DE CONTENIR UN NOM DE MÍNIM UNA LLETRA", result3);
        assertEquals("AQUEST PRODUCTE HA DE TENIR UN NOM DE MÍNIM 2 CARÀCTERS", result4);
        assertEquals("AQUEST PRODUCTE HA DE TENIR UN NOM DE MÀXIM 12 CARÀCTERS", result5);
        assertEquals("AQUEST PRODUCTE HA DE TENIR UNA DESCRIPCIÓ DE MÀXIM 20 CARÀCTERS", result6);

    }

    /*
    Utilitzem quatre casos de constructor per obtenir les diferentes particions equivalents.
            CASOS:
            - happy path: retorn de quantitat i objectes correcte
    */
    @Test
    void getProductsTest(){
        //INICIAR MOCK AMB DADES DE PRODUCTES
        prodC.initProducts();

        //CREAR LLIST EXPECTED DE PRODUCTES
        ArrayList<Product> expected = this.getListOfProducts(3);
        doReturn(expected).when(ProductService).getAll();

        //CRIDAR FUNCIÓ A TESTEJAR
        ArrayList<Product> result = prodC.getProducts();

        //COMPROVACIÓ
        verify(ProductService).getAll();
        assertEquals(expected, result);
    }

    private ArrayList<Product> getListOfProducts(int N){
        ArrayList<Product> products = new ArrayList<>();

        for(int i=0; i<N;i++) {
            Product product = new Product("Masaje " + i, 10.20 * (i + 1), "Masaje");

            products.add(product);
        }

        return products;
    }
}
