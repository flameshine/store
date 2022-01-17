package com.flameshine.store.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.flameshine.store.entity.Product;

/**
 * Repository that handles the {@link com.flameshine.store.entity.Product} entity.
 */

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> { }