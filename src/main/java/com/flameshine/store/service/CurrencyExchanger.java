package com.flameshine.store.service;

import com.flameshine.store.entity.Product;

/**
 * Class responsible for exchanging product prices from one currency to another.
 */

public interface CurrencyExchanger {
    void exchange(Product product, String currentCurrency, String targetCurrency);
}