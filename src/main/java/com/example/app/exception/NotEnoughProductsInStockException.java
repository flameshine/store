package com.example.app.exception;

/**
 * Exception to indicate that products are out of stock.
 */

public class NotEnoughProductsInStockException extends Exception {

    public NotEnoughProductsInStockException(String message) {
        super(message);
    }
}