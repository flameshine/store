package com.example.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.service.PurchaseService;
import com.example.app.entity.Purchase;

/**
 * Controller for the {@link com.example.app.entity.Purchase} entity.
 */

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    // TODO: add logging

    private final PurchaseService service;

    @Autowired
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("/purchases")
            .addObject(service.findAll());
    }

    @PostMapping
    public void save(@RequestBody Purchase product) {
        service.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}