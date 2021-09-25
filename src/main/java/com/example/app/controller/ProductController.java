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
    // TODO: cover cases when a product with received id not found

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

    @PostMapping
    public String save(@RequestBody Product product) {
        service.save(product);
        return "redirect:/products";
    }

    @PutMapping("/{id}")
    public String update(
        @RequestBody Product product,
        @PathVariable("id") Long id
    ) {
        if (id.equals(product.getId())) {
            // TODO: add corresponding logic
        }

        service.findById(id).ifPresent(service::save);

        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/products";
    }
}