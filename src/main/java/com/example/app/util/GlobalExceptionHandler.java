package com.example.app.util;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

/**
 * Class that handles application unexpected errors.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    // TODO: add logging

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ModelAndView handle(Throwable throwable) {
        return new ModelAndView("/error")
            .addObject("error", throwable.getMessage());
    }
}