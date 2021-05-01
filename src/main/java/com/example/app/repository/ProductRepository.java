package com.example.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Product;

/**
 * Repository that handles the {@link com.example.app.entity.Product} entity.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}