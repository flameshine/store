package com.flameshine.store.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;

import com.flameshine.store.model.Currency;
import com.flameshine.store.service.ProductOperator;
import com.flameshine.store.service.CurrencyExchanger;
import com.flameshine.store.repository.ProductRepository;
import com.flameshine.store.entity.Product;

/**
 * Implementation of {@link com.flameshine.store.service.ProductOperator}.
 */

@Service
@Transactional
@RequiredArgsConstructor
public class ProductOperatorImpl implements ProductOperator {

    private final ProductRepository repository;
    private final CurrencyExchanger exchanger;

    @Override
    public Page<Product> findAllPageable(Pageable pageable, Currency currency) {

        var products = repository.findAll(pageable);

        products.forEach(
            product -> exchange(
                product, Objects.requireNonNullElseGet(currency, product::getCurrency)
            )
        );

        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    private void exchange(Product product, Currency target) {

        var price = exchanger.exchange(
            product.getPrice(), product.getCurrency(), target
        );

        product.setPrice(price);
        product.setCurrency(target);
    }
}