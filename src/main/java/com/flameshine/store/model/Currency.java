package com.flameshine.store.model;

/**
 * Enumeration of allowed currency codes.
 */

public enum Currency {

    UAH,
    USD,
    EUR,
    PLN,
    GBP;

    @Override
    public String toString() {
        return name();
    }
}