package com.example.fisioshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTest {
    
    CategoryController categC = new CategoryController();
    int N = 3;

    @Test
    void getCategoryTest(){
        ArrayList<Category> expected = this.getListOfCategories(N);
        ArrayList<Category> result = categC.getCategories();

        assertEquals(expected, result);
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
