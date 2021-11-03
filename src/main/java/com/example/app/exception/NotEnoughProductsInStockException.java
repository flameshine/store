package com.example.app.exception;

import java.io.Serial;

/**
 * Exception to indicate that products are out of stock.
 */

public class NotEnoughProductsInStockException extends Exception {

    @Serial
    private static final long serialVersionUID = -2103011895013555471L;

    public NotEnoughProductsInStockException(String message) {
        super(message);
    }
}