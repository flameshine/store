package com.flameshine.store.service;

import java.math.BigDecimal;

import com.flameshine.store.model.Currency;

/**
 * Class responsible for exchanging a given amount from one currency to another.
 */

public interface CurrencyExchanger {
    BigDecimal exchange(BigDecimal amount, Currency current, Currency target);
}