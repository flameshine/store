package com.example.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.app.entity.User;

/**
 * Controller for the {@link com.example.app.entity.User} entity.
 */

@RequestMapping("/users")
public interface UserController {

    @GetMapping
    List<User> findAll();

    @GetMapping("/{id}")
    User findById(@PathVariable("id") Long id);

    @PostMapping
    void save(@RequestBody User user);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}