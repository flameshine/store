package com.flameshine.store.service;

import com.flameshine.store.entity.Product;
import com.flameshine.store.model.Currency;

/**
 * Class that exchanges product price by the given currency.
 */

public interface CurrencyExchanger {
    void exchange(Product product, Currency currency);
}