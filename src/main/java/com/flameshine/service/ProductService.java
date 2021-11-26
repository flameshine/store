package com.flameshine.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.entity.Product;

/**
 * Service for the basic interactions with {@link com.flameshine.entity.Product} entity.
 */

public interface ProductService {

    Page<Product> findAllPageable(Pageable pageable);

    Optional<Product> findById(Long id);
}