package com.flameshine.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.flameshine.service.UserService;
import com.flameshine.util.Constants;
import com.flameshine.entity.User;

/**
 * Controller for the registration page.
 */

@Controller
@RequestMapping(Constants.REGISTRATION_PATH)
public class RegistrationController {

    private final UserService service;

    public RegistrationController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView registration() {
        return new ModelAndView(Constants.REGISTRATION_PATH)
            .addObject("user", new User());
    }

    @PostMapping
    public ModelAndView registration(@Valid User user, BindingResult bindingResult) {

        if (service.findByUsername(user.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.user", "This username is already taken");
        }

        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            bindingResult.rejectValue("passwordConfirmation", "error.user", "Password mismatch");
        }

        if (service.findByEmail(user.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.user", "This email is already taken");
        }

        if (!bindingResult.hasErrors()) {

            service.save(user);

            return new ModelAndView(Constants.LOGIN_PATH)
                .addObject("message", "User has been registered successfully");
        }

        return new ModelAndView(Constants.REGISTRATION_PATH);
    }
}