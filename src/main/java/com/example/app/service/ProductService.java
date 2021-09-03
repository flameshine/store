package com.example.app.service;

import java.util.List;
import java.util.Optional;

import com.example.app.entity.Product;

/**
 * Service for the basic interactions with {@link com.example.app.entity.Product} entity.
 */

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product role);

    void deleteById(Long id);
}