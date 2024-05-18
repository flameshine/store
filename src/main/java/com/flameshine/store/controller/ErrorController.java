package com.flameshine.store.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import com.flameshine.store.util.Constants;

/**
 * Controller responsible for handling various unexpected errors.
 */

@ControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(Exception.class)
    protected ModelAndView handle(Exception e) {
        log.error("An unhandled exception has occurred", e);
        return new ModelAndView(Constants.ERROR_PATH)
            .addObject("message", e.getMessage());
    }
}
