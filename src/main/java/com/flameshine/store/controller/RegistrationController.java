package com.flameshine.store.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.flameshine.store.service.UserService;
import com.flameshine.store.validation.UserValidator;
import com.flameshine.store.util.Constants;
import com.flameshine.store.entity.User;

/**
 * Controller for the registration page.
 */

@Controller
@RequestMapping(Constants.REGISTRATION_PATH)
public class RegistrationController {

    private final UserService service;
    private final UserValidator validator;

    @Autowired
    public RegistrationController(UserService service, UserValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @GetMapping
    public ModelAndView registration() {
        return new ModelAndView(Constants.REGISTRATION_PATH)
            .addObject("user", new User());
    }

    @PostMapping
    public ModelAndView registration(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView(Constants.REGISTRATION_PATH);
        }

        service.save(user);

        return new ModelAndView(Constants.LOGIN_PATH)
            .addObject("message", "User has been registered successfully");
    }

    @InitBinder
    private void bindValidator(WebDataBinder binder) {
        binder.setValidator(validator);
    }
}