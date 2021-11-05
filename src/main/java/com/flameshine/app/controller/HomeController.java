package com.flameshine.app.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import com.flameshine.app.service.ProductService;
import com.flameshine.app.util.Constants;
import com.flameshine.app.util.Pager;

/**
 * Controller for the application home page.
 */

@Controller
public class HomeController {

    private final ProductService service;

    @Autowired
    public HomeController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping({ "/", Constants.HOME_PATH })
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        var products = service.findAllPageable(
            PageRequest.of(
                page.orElse(0),
                5
            )
        );

        return new ModelAndView(Constants.HOME_PATH)
            .addObject("products", products)
            .addObject("pager", new Pager(products));
    }
}