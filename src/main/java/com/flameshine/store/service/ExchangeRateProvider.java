package com.flameshine.store.service;

import java.math.BigDecimal;

/**
 * Class responsible for providing the actual currency exchange rate.
 */

public interface ExchangeRateProvider {
    BigDecimal provide(String currentCurrency, String targetCurrency);
}