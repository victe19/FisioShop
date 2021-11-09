package com.example.fisioshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProdController {

    @Autowired
    private ProductRepository productRepository;

    /*@PostMapping("/addP")
    public String addProduct(@RequestParam String name, @RequestParam Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);
        return "Added new product to repo!";
    } */

    @GetMapping("/findP/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return productRepository.findProductById(id);
    }
}