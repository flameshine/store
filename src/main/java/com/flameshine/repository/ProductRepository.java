package com.flameshine.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flameshine.entity.Product;

/**
 * Repository that handles the {@link com.flameshine.entity.Product} entity.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}