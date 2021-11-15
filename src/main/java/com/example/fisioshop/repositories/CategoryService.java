package com.example.fisioshop.repositories;

import com.example.fisioshop.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories;
    
    public void initCategories(){
        for(int i=0; i<5;i++) {
            //if(i < 3){
            Category category = new Category("Tractaments " + i);
            categories.add(category);
        }
    }
    
    public ArrayList<Category> getAll() {
        return this.categories;
    }
}
