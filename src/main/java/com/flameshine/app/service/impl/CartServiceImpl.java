package com.flameshine.app.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import com.flameshine.app.service.CartService;
import com.flameshine.app.repository.ProductRepository;
import com.flameshine.app.exception.NotEnoughProductsInStockException;
import com.flameshine.app.entity.Product;

/**
 * Implementation of {@link com.flameshine.app.service.CartService}.
 */

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;
    private final Map<Product, Integer> products;

    @Autowired
    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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

        if (!products.containsKey(product)) {
            return;
        }

        var quantity = products.get(product);

        if (quantity > 1) {
            products.replace(product, quantity - 1);
        } else if (quantity == 1) {
            products.remove(product);
        }
    }

    @Override
    @Transactional
    public void checkout() throws NotEnoughProductsInStockException {

        for (var entry : products.entrySet()) {

            var productId = entry.getKey().getId();

            var product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException(
                    String.format(
                        "Product with id %d not found",
                        productId
                    ))
                );

            var quantity = product.getQuantity();

            if (quantity < entry.getValue()) {
                throw new NotEnoughProductsInStockException(
                    String.format(
                        "Not enough '%s' products in the stock. Only %d left",
                        product.getName(),
                        quantity
                    )
                );
            }

            entry.getKey().setQuantity(quantity - entry.getValue());
        }

        productRepository.saveAll(products.keySet());

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