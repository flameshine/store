package com.example.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.service.CategoryService;
import com.example.app.entity.Category;

/**
 * Controller for the {@link com.example.app.entity.Category} entity.
 */

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id) {
        return service.findById(id);
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