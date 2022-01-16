package com.flameshine.store.service;

import java.math.BigDecimal;

import com.flameshine.store.model.Currency;

/**
 * Class responsible for providing the actual currency exchange rate.
 */

public interface ExchangeRateProvider {
    BigDecimal provide(Currency from, Currency to);
}