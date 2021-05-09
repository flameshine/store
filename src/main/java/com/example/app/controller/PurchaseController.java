package com.example.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.service.PurchaseService;
import com.example.app.entity.Purchase;

/**
 * Controller for the {@link com.example.app.entity.Purchase} entity.
 */

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService service;

    @Autowired
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Purchase> findAll() {
        return service.findAll();
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