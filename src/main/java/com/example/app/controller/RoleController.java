package com.example.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.app.entity.Role;

/**
 * Controller for the {@link com.example.app.entity.Role} entity.
 */

@RequestMapping("/roles")
public interface RoleController {

    @GetMapping
    List<Role> findAll();

    @GetMapping("/{id}")
    Role findById(@PathVariable("id") Long id);

    @PostMapping
    void save(@RequestBody Role role);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}