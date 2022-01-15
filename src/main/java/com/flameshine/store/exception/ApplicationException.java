package com.flameshine.store.exception;

import java.io.Serial;

/**
 * General application exception.
 */

public class ApplicationException extends RuntimeException {

    // TODO: review its usage

    @Serial
    private static final long serialVersionUID = -4916980636567123662L;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}