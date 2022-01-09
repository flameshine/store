package com.flameshine.store.validation;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import com.flameshine.store.service.UserService;
import com.flameshine.store.entity.User;

/**
 * Validator for the {@link com.flameshine.store.entity.User} entity.
 */

@Component
public class UserValidator implements Validator {

    private final UserService service;

    @Autowired
    public UserValidator(UserService service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> type) {
        return User.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        var user = (User) target;

        if (service.findByUsername(user.getUsername()).isPresent()) {
            errors.rejectValue("username", "error.user", "This username is already taken");
        }

        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            errors.rejectValue("passwordConfirmation", "error.user", "Password mismatch");
        }

        if (service.findByEmail(user.getEmail()).isPresent()) {
            errors.rejectValue("email", "error.user", "This email is already taken");
        }
    }
}