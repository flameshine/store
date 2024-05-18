package com.flameshine.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;
import lombok.RequiredArgsConstructor;

import com.flameshine.store.model.Currency;
import com.flameshine.store.service.ProductOperator;
import com.flameshine.store.util.Constants;

/**
 * Products page controller.
 */

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductOperator operator;

    @GetMapping(Constants.PRODUCTS_PATH)
    public ModelAndView home(
        @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
        @RequestParam(value = "currency", required = false, defaultValue = "USD") Currency currency
    ) {

        var pageRequest = PageRequest.of(
            page == 0 ? 0 : page - 1,
            Constants.DEFAULT_PAGE_SIZE
        );

        var products = operator.findAllPageable(pageRequest, currency);

        return new ModelAndView(Constants.PRODUCTS_PATH)
            .addObject("products", products)
            .addObject("currencies", Currency.values());
    }
}