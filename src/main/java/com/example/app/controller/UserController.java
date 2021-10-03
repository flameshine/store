package com.example.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.service.UserService;
import com.example.app.entity.User;

/**
 * Controller for the {@link com.example.app.entity.User} entity.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    // TODO: add logging
    // TODO: cover cases when a user with received id not found

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAllPageable(
        @RequestParam("0") int initialPageNumber,
        @RequestParam("5") int size
    ) {
        return new ModelAndView("/users")
            .addObject(service.findAllPageable(PageRequest.of(initialPageNumber, size)));
    }

    @PostMapping
    public String save(@RequestBody User user) {
        service.save(user);
        return "redirect:/users";
    }

    @PutMapping
    public String update(@RequestBody User user) {

        if (service.findById(user.getId()).isEmpty()) {
            // TODO: add corresponding logic
        }

        service.save(user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/users";
    }
}