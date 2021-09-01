package com.example.app.service;

import java.util.Map;
import java.math.BigDecimal;

import com.example.app.exception.NotEnoughProductsInStockException;
import com.example.app.entity.Product;

/**
 * Service for interacting with the shopping cart.
 */

public interface CartService {

    void add(Product product);

    void remove(Product product);

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotalAmount();

    Map<Product, Integer> getProducts();
}