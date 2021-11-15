package com.example.fisioshop.repositories;

import com.example.fisioshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}