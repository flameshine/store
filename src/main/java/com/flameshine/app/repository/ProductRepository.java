package com.flameshine.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flameshine.app.entity.Product;

/**
 * Repository that handles the {@link com.flameshine.app.entity.Product} entity.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}