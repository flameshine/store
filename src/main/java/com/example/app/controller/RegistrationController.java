package com.example.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.example.app.service.UserService;
import com.example.app.entity.User;

/**
 * Controller for the registration page.
 */

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService service;

    public RegistrationController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView registration() {
        return new ModelAndView("/registration")
            .addObject("user", new User());
    }

    @PostMapping
    public ModelAndView registration(@Valid User user, BindingResult bindingResult) {

        if (service.findByUsername(user.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.user", "This username is already taken");
        }

        if (service.findByEmail(user.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.user", "This email is already taken");
        }

        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            bindingResult.rejectValue("passwordConfirmation", "error.user", "Password mismatch");
        }

        var modelAndView = new ModelAndView("/registration");

        if (!bindingResult.hasErrors()) {
            service.save(user);
            modelAndView.addObject("message", "User has been registered successfully");
        }

        return modelAndView;
    }
}