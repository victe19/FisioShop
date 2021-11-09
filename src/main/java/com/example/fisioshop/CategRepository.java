package com.example.fisioshop;

import org.springframework.data.repository.CrudRepository;

public interface CategRepository extends CrudRepository<Category, Integer> {

    Category findCategoryById(Integer id);
}