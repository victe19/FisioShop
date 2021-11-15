package com.example.fisioshop.controllers;

import com.example.fisioshop.models.Category;

import java.util.ArrayList;

public class CategoryController {
    public ArrayList<Category> getCategories() {
        return new ArrayList<>();
    }

    public String addCategory(String name) {
        return "creat";
    }
}
