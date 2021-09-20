package com.example.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.app.entity.Product;

/**
 * Repository that handles the {@link com.example.app.entity.Product} entity.
 */

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    // TODO: add sorting
}