package com.example.fisioshop.repositories;

import com.example.fisioshop.models.Category;
import com.example.fisioshop.models.Customer;
import com.example.fisioshop.models.Order;
import com.example.fisioshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class OrderService {

    ArrayList<Order> orders;

    public void initOrders(){
        ArrayList<Product> products = null;
        Customer customer1 = new Customer("Victor", "Arauzo");
        for (int i = 0; i < 3; i++) {
            assert false;
             products.add(new Product("product" + i, 10.00, "test Order"));
        }
        for(int i=0; i<5;i++) {
            //if(i < 3){
            Order order = new Order("order1", 100.0, customer1, products);
            orders.add(order);
        }
    }

    public ArrayList<Order> getAll() {
        return this.orders;
    }
}
