package com.flameshine.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.app.service.ProductService;
import com.flameshine.app.repository.ProductRepository;
import com.flameshine.app.entity.Product;

/**
 * Implementation of {@link com.flameshine.app.service.ProductService}.
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Product> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}