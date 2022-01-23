package com.flameshine.store.service;

import java.math.BigDecimal;

/**
 * Class responsible for exchanging a given amount from one currency to another.
 */

public interface CurrencyExchanger {
    BigDecimal exchange(BigDecimal amount, String currentCurrency, String targetCurrency);
}