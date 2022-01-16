package com.flameshine.store.service;

import java.util.Map;
import java.math.BigDecimal;

import com.flameshine.store.entity.Product;

/**
 * Class responsible for operating with the shopping cart.
 */

public interface CartOperator {

    void add(Product product);

    void remove(Product product);

    void checkout();

    BigDecimal getTotalAmount();

    Map<Product, Integer> getProducts();
}