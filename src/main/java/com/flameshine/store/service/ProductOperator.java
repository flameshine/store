package com.flameshine.store.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.store.entity.Product;
import com.flameshine.store.model.Currency;

/**
 * Class responsible for operating with the {@link com.flameshine.store.entity.Product} entity.
 */

public interface ProductOperator {

    Page<Product> findAllPageable(Pageable pageable, Currency currency);

    Optional<Product> findById(Long id);
}