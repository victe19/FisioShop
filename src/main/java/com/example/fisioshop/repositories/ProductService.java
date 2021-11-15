package com.example.fisioshop.repositories;

import com.example.fisioshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products;
    
    public void initProducts(){
        for(int i=0; i<5;i++) {
            //if(i < 3){
            Product product = new Product("Masaje " + i, 10.20 * (i + 1), "descripcion producto " + i);
            products.add(product);
        }
    }
    
    public ArrayList<Product> getAll() {
        return this.products;
    }
}
