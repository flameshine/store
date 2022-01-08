package com.flameshine.store.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.flameshine.store.service.CartService;
import com.flameshine.store.repository.ProductRepository;
import com.flameshine.store.entity.Product;

/**
 * Implementation of {@link com.flameshine.store.service.CartService}.
 */

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    private final ProductRepository repository;
    private final Map<Product, Integer> products;

    @Autowired
    public CartServiceImpl(ProductRepository repository) {
        this.repository = repository;
        this.products = new HashMap<>();
    }

    @Override
    public void add(Product product) {

        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    @Override
    public void remove(Product product) {

        var quantity = products.get(product);

        if (quantity > 1) {
            products.replace(product, quantity - 1);
        } else if (quantity == 1) {
            products.remove(product);
        }
    }

    @Override
    @Transactional
    public void checkout() {

        products.forEach((product, cartQuantity) -> repository.findById(product.getId())
            .map(Product::getQuantity)
            .ifPresent(quantity -> product.setQuantity(quantity - cartQuantity))
        );

        repository.saveAll(
            products.keySet()
        );

        products.clear();
    }

    @Override
    public BigDecimal getTotalAmount() {
        return products.entrySet().stream()
            .map(x -> x.getKey().getPrice().multiply(BigDecimal.valueOf(x.getValue())))
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
    }

    @Override
    public Map<Product, Integer> getProducts() {
        return Map.copyOf(products);
    }
}