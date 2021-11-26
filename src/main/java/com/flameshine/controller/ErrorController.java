package com.flameshine.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import com.flameshine.util.Constants;

/**
 * Controller that handles various unexpected errors.
 */

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ModelAndView handle(Exception e) {
        return new ModelAndView(Constants.ERROR_PATH)
            .addObject("message", e.getMessage());
    }
}