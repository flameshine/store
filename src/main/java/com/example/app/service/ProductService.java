package com.example.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.app.entity.Product;

/**
 * Service for the basic interactions with {@link com.example.app.entity.Product} entity.
 */

public interface ProductService {

    void save(Product product);

    Page<Product> findAllPageable(Pageable pageable);

    Optional<Product> findById(Long id);

    void deleteById(Long id);
}