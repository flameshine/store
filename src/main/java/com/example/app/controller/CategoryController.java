package com.example.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.service.CategoryService;
import com.example.app.entity.Category;

/**
 * Controller for the {@link com.example.app.entity.Category} entity.
 */

@RestController
@RequestMapping("/categories")
public class CategoryController {

    // TODO: add logging

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("/categories")
            .addObject(service.findAll());
    }

    @PostMapping
    public void save(@RequestBody Category category) {
        service.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}