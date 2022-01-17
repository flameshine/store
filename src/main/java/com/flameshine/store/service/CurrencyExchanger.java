package com.flameshine.store.service;

import com.flameshine.store.entity.Product;
import com.flameshine.store.model.Currency;

/**
 * Class responsible for exchanging product prices from one currency to another.
 */

public interface CurrencyExchanger {
    void exchange(Product product, Currency from, Currency to);
}