package com.example.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.service.ProductService;
import com.example.app.entity.Product;

/**
 * Controller for the {@link com.example.app.entity.Product} entity.
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    // TODO: add logging

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAllPageable(
        @RequestParam("0") int initialPageNumber,
        @RequestParam("5") int size
    ) {
        return new ModelAndView("/products")
            .addObject(service.findAllPageable(PageRequest.of(initialPageNumber, size)));
    }

    @PostMapping("/save")
    public void save(@RequestBody Product product) {
        service.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}