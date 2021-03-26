package com.example.app.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.service.ProductService;
import com.example.app.repository.ProductRepository;
import com.example.app.entity.Product;

/**
 * Implementation of {@link com.example.app.service.ProductService}.
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
    public List<Product> findAll() {
        return List.copyOf(repository.findAll());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Product with id %d not found.", id)));
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}