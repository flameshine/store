package com.flameshine.store.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import com.flameshine.store.service.ProductService;
import com.flameshine.store.util.Constants;
import com.flameshine.store.util.Pager;
import com.flameshine.store.model.Currency;

/**
 * Controller for the application products page.
 */

@Controller
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
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
            ),
            currency.orElse(Constants.DEFAULT_CURRENCY)
        );

        return new ModelAndView(Constants.PRODUCTS_PATH)
            .addObject("products", products)
            .addObject("pager", new Pager(products));
    }
}