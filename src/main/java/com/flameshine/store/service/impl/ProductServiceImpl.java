package com.flameshine.store.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.store.service.ProductService;
import com.flameshine.store.repository.ProductRepository;
import com.flameshine.store.util.CurrencyConverter;
import com.flameshine.store.util.Constants;
import com.flameshine.store.entity.Product;
import com.flameshine.store.model.Currency;

/**
 * Implementation of {@link com.flameshine.store.service.ProductService}.
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CurrencyConverter converter;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, CurrencyConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Page<Product> findAllPageable(Pageable pageable, Currency currency) {

        var products = repository.findAll(pageable);

        products.forEach(product -> product.setPrice(
            converter.convert(
                product.getPrice(), Constants.DEFAULT_CURRENCY, currency
            ))
        );

        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}