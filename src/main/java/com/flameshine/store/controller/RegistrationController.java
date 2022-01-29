package com.flameshine.store.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;

import com.flameshine.store.service.UserOperator;
import com.flameshine.store.validator.UserValidator;
import com.flameshine.store.util.Constants;
import com.flameshine.store.entity.User;

/**
 * Registration page controller.
 */

@Controller
@RequestMapping(Constants.REGISTRATION_PATH)
@RequiredArgsConstructor
public class RegistrationController {

    private final UserOperator operator;
    private final UserValidator validator;

    @GetMapping
    public ModelAndView registration() {
        return new ModelAndView(Constants.REGISTRATION_PATH)
            .addObject("user", new User());
    }

    @PostMapping
    public ModelAndView registration(
        @Valid User user,
        BindingResult result
    ) {

        if (result.hasErrors()) {
            return new ModelAndView(Constants.REGISTRATION_PATH);
        }

        operator.save(user);

        return new ModelAndView(Constants.LOGIN_PATH)
            .addObject("message", "User has been registered successfully");
    }

    @InitBinder
    private void bindValidator(WebDataBinder binder) {
        binder.setValidator(validator);
    }
}