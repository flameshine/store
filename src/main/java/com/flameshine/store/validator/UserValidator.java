package com.flameshine.store.validator;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import com.flameshine.store.service.UserOperator;
import com.flameshine.store.entity.User;

/**
 * Validator for the {@link com.flameshine.store.entity.User} entity.
 */

@Component
public class UserValidator implements Validator {

    private static final String ERROR_CODE = "error.user";

    private final UserOperator service;

    @Autowired
    public UserValidator(UserOperator service) {
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
            errors.rejectValue("username", ERROR_CODE, "This username is already taken");
        }

        if (service.findByEmail(user.getEmail()).isPresent()) {
            errors.rejectValue("email", ERROR_CODE, "This email is already taken");
        }

        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            errors.rejectValue("passwordConfirmation", ERROR_CODE, "Password mismatch");
        }
    }
}