package com.flameshine.store.service;

import java.math.BigDecimal;

/**
 * Class responsible for exchanging product prices from one currency to another.
 */

public interface CurrencyExchanger {
    BigDecimal exchange(BigDecimal amount, String currentCurrency, String targetCurrency);
}