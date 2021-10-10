package com.example.app.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.service.UserService;
import com.example.app.util.Pager;
import com.example.app.entity.User;

/**
 * Controller for the {@link com.example.app.entity.User} entity.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAllPageable(@RequestParam("page") Optional<Integer> page) {

        var users = service.findAllPageable(
            PageRequest.of(
                page.orElse(0) < 1 ? 0 : page.get() - 1,
                5
            )
        );

        return new ModelAndView("/users")
            .addObject("users", users)
            .addObject("pager", new Pager(users));
    }

    @PostMapping
    public String save(@RequestBody User user) {
        service.save(user);
        return "redirect:/users";
    }

    @PutMapping
    public String update(@RequestBody User user) {
        service.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/users";
    }
}