package com.example.fisioshop.controllers;

import com.example.fisioshop.models.Product;
import com.example.fisioshop.repositories.ProductRepository;
import com.example.fisioshop.repositories.ProductService;
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
        //CONDICIONS NOM
        if (name.length()< 2 || name.length() > 12){
            if(name.length() < 2){
                return "AQUEST PRODUCTE HA DE TENIR UN NOM DE MÍNIM 2 CARÀCTERS";
            }else return "AQUEST PRODUCTE HA DE TENIR UN NOM DE MÀXIM 12 CARÀCTERS";
        }
        if (!name.contains("[a-zA-Z]+")){
            return "AQUEST PRODUCTE HA DE CONTENIR UN NOM DE MÍNIM UNA LLETRA";
        }
        //CONDICIONS PREU
        if (price == 0.0){
            return "AQUEST PRODUCTE HA DE TENIR UN PREU SUPERIOR A 0";
        }
        //CONDICIONS DESCRIPCIO
        if (description.length() > 20){
            return "AQUEST PRODUCTE HA DE TENIR UNA DESCRIPCIÓ DE MÀXIM 20 CARÀCTERS";
        }
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        productRepository.save(product);

        return "AQUEST PRODUCTE S'HA CREAT CORRECTAMENT";
    }
}