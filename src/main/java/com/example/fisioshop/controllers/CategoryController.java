package com.example.fisioshop.controllers;

import com.example.fisioshop.models.Category;
import com.example.fisioshop.repositories.CategoryRepository;
import com.example.fisioshop.repositories.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoryController {
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryService categoryService) {
    }

    @GetMapping("/ListC")
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = categoryService.getAll();

        return categories;
    }

    @PostMapping("/initc")
    public void initCategories(){
        categoryService.initCategories();
    }

    @PostMapping("/addC")
    public String addCategory(String name) {
        //CONDICIONS NOM
        if (name.length()< 2 || name.length() > 12){
            if(name.length() < 2){
                return "AQUESTA CATEGORIA HA DE TENIR UN NOM DE MÍNIM 2 CARÀCTERS";
            }else return "AQUESTA CATEGORIA HA DE TENIR UN NOM DE MÀXIM 12 CARÀCTERS";
        }
        if (!name.contains("[a-zA-Z]+")){
            return "AQUEST PRODUCTE HA DE CONTENIR UN NOM DE MÍNIM UNA LLETRA";
        }


        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);

        return "AQUEST CATEGORIA S'HA CREAT CORRECTAMENT";
    }
}
