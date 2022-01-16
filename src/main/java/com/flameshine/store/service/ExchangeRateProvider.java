package com.flameshine.store.service;

import java.math.BigDecimal;

import com.flameshine.store.model.Currency;

/**
 * Class that provides the actual currency exchange rate.
 */

public interface ExchangeRateProvider {
    BigDecimal provide(Currency from, Currency to);
}