package com.flameshine.store.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import com.flameshine.store.util.Constants;

/**
 * Controller that handles various unexpected errors.
 */

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ModelAndView handle(Exception e) {

        e.printStackTrace();

        return new ModelAndView(Constants.ERROR_PATH)
            .addObject("message", e.getMessage());
    }
}