package com.example.app.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

/**
 * Controller that handles various unexpected errors.
 */

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ModelAndView handle(Exception e) {
        return new ModelAndView("/error")
            .addObject("message", e.getMessage());
    }
}