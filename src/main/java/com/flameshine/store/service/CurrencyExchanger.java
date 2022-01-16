package com.flameshine.store.service;

import com.flameshine.store.entity.Product;
import com.flameshine.store.model.Currency;

/**
 * Class responsible for exchanging product price for a given currency.
 */

public interface CurrencyExchanger {
    void exchange(Product product, Currency currency);
}