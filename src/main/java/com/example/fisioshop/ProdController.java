package com.example.fisioshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProdController {

    private ProductService productService;
    private ProductRepository productRepository;

    @Autowired
    public ProdController(ProductService productService) {
    }

    /*@GetMapping("/findP/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return productRepository.findProductById(id);
    }*/

    @GetMapping("/ListP")
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = productService.getAll();

        return products;
    }
    
    @PostMapping("/initP")
    public void initProducts(){
        productService.initProducts();
    }

    @PostMapping("/addP")
    public String addProduct(String name, double price, String description) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        productRepository.save(product);
        return "AQUEST PRODUCTE S'HA CREAT CORRECTAMENT";
    }
}