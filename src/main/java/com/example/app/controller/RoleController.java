package com.example.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.service.RoleService;
import com.example.app.entity.Role;

/**
 * Controller for the {@link com.example.app.entity.Role} entity.
 */

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    @Autowired
    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Role> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Role role) {
        service.save(role);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}