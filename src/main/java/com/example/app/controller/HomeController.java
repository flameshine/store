package com.example.app.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import com.example.app.service.ProductService;
import com.example.app.util.Pager;

/**
 * Controller for the application home page.
 */

@Controller
public class HomeController {

    // TODO: add logging

    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({ "/", "/home" })
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        var products = productService.findAllPageable(
            PageRequest.of(
                page.orElse(0) < 1 ? 0 : page.get() - 1,
                5
            )
        );

        return new ModelAndView("/home")
            .addObject("products", products)
            .addObject("pager", new Pager(products));
    }
}