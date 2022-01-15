package com.flameshine.store.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import com.flameshine.store.service.ProductService;
import com.flameshine.store.util.CurrencyConverter;
import com.flameshine.store.util.Constants;
import com.flameshine.store.util.Pager;
import com.flameshine.store.model.Currency;

/**
 * Controller for the application products page.
 */

@Controller
public class ProductController {

    private final ProductService service;
    private final CurrencyConverter converter;

    @Autowired
    public ProductController(ProductService service, CurrencyConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping(Constants.PRODUCTS_PATH)
    public ModelAndView home(
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("currency") Optional<Currency> currency
    ) {

        var products = service.findAllPageable(
            PageRequest.of(
                page.map(i -> i - 1).orElse(0),
                5
            )
        );

        products.forEach(product -> product.setPrice(
            converter.convert(
                product.getPrice(), Constants.DEFAULT_CURRENCY, currency.orElse(Constants.DEFAULT_CURRENCY)
            ))
        );

        return new ModelAndView(Constants.PRODUCTS_PATH)
            .addObject("products", products)
            .addObject("pager", new Pager(products));
    }
}