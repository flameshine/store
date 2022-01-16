package com.flameshine.store.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import com.flameshine.store.service.ProductOperator;
import com.flameshine.store.service.CurrencyExchanger;
import com.flameshine.store.util.Pager;
import com.flameshine.store.util.Constants;
import com.flameshine.store.model.Currency;

/**
 * Products page controller.
 */

@Controller
public class ProductController {

    private final ProductOperator operator;
    private final CurrencyExchanger exchanger;

    @Autowired
    public ProductController(ProductOperator operator, CurrencyExchanger exchanger) {
        this.operator = operator;
        this.exchanger = exchanger;
    }

    @GetMapping(Constants.PRODUCTS_PATH)
    public ModelAndView home(
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("currency") Optional<Currency> currency
    ) {

        var products = operator.findAllPageable(
            PageRequest.of(
                page.map(i -> i - 1).orElse(0),
                5
            )
        );

        products.forEach(product -> exchanger.exchange(
            product, currency.orElse(product.getCurrency()))
        );

        return new ModelAndView(Constants.PRODUCTS_PATH)
            .addObject("products", products)
            .addObject("pager", new Pager(products));
    }
}