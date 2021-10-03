package com.example.app.util;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

/**
 * Class that handles application unexpected errors.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    // TODO: add a corresponding error page

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Object> handle(Throwable throwable) {
        return new ResponseEntity<>(
            String.format("An unexpected error has occurred: %s", throwable.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}