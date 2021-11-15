package com.example.fisioshop;

import com.example.fisioshop.controllers.CategoryController;
import com.example.fisioshop.models.Category;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTest {

    ArrayList<Category> categories_r1 = new ArrayList<>();
    ArrayList<Category> categories_r2 = new ArrayList<>();

    /*
    Utilitzem sis casos de paràmetres per obtenir les diferentes particions equivalents.
            CASOS:
            - happy path: valor correctes.
            - sad path: posem limitacions als atributs:
                · name: entre 2 i 12, mínim una lletra i sense numeros
    */


    @Mock
    CategoryService CategoryService;

    CategoryController categC = new CategoryController(CategoryService);
    int N = 3;

    @Test
    void addCategoryTest(){
        //CASOS HAPPY PATH
        String result1 = categC.addCategory("Tractaments"); //HAPPY PATH

        //CASOS SAD PATH

        String result2 = categC.addCategory(""); //SAD PATH NAME 1 (buid)
        String result3 = categC.addCategory("a"); //SAD PATH NAME 2 (curt)
        String result4 = categC.addCategory("El nom d'aquesta categoria es massa llarg"); //SAD PATH NAME 3 (llarg)
        String result5 = categC.addCategory("1"); //SAD PATH NAME 3 (NUM ASCII)
        //String result6 = categC.addCategory(1); //SAD PATH NAME 3 (NUM)



        assertEquals("AQUESTA CATEGORIA S'HA CREAT CORRECTAMENT", result1);
        assertEquals("AQUESTA CATEGORIA HA DE TENIR UN NOM DE MÍNIM 2 CARÀCTERS", result2);
        assertEquals("AQUESTA CATEGORIA HA DE TENIR UN NOM DE MÍNIM 2 CARÀCTERS", result3);
        assertEquals("AQUESTA CATEGORIA HA DE TENIR UN NOM DE MÀXIM 12 CARÀCTERS", result4);
        assertEquals("AQUESTA CATEGORIA HA DE TENIR UN NOM, NO UN NUMERO", result5);
        //assertEquals("AQUESTA CATEGORIA HA DE TENIR UN NOM, NO UN NUMERO", result6);

    }

    @Test
    void getCategoryTest(){
        //INICIAR MOCK AMB CCATEGORIES DE PRODUCTES
        categC.initCategories();

        //CREAR LLIST EXPECTED DE PRODUCTES
        ArrayList<Category> expected = this.getListOfCategories(N);
        doReturn(expected).when(CategoryService).getAll();

        //CRIDAR FUNCIÓ A TESTEJAR
        ArrayList<Category> result = categC.getCategories();

        //COMPROVACIÓ
        verify(CategoryService).getAll();
        Assertions.assertEquals(expected, result);


    }

    private ArrayList<Category> getListOfCategories(int N) {
        ArrayList<Category> categories = new ArrayList<>();

        for(int i=0; i<N;i++) {
            Category category = new Category("Masajes " + i);

            categories.add(category);
        }

        return categories;
    }
}
