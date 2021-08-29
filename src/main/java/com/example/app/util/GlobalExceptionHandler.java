package com.example.app.util;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

/**
 * Class that handles application unexpected errors.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Object> handle(Throwable throwable) {
        var message = String.format("An unexpected error has occurred: %s", throwable.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}