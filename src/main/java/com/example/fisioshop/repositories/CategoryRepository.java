package com.example.fisioshop.repositories;

import com.example.fisioshop.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findCategoryById(Integer id);
}