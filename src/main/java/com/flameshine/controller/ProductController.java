package com.flameshine.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import com.flameshine.service.ProductService;
import com.flameshine.util.Constants;
import com.flameshine.util.Pager;

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
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        var products = service.findAllPageable(
            PageRequest.of(
                page.map(i -> i - 1).orElse(0),
                5
            )
        );

        return new ModelAndView(Constants.PRODUCTS_PATH)
            .addObject("products", products)
            .addObject("pager", new Pager(products));
    }
}