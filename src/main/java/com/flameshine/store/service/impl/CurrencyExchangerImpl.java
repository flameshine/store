package com.flameshine.store.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.flameshine.store.service.CurrencyExchanger;
import com.flameshine.store.service.ExchangeRateProvider;
import com.flameshine.store.entity.Product;

/**
 * Implementation of {@link com.flameshine.store.service.CurrencyExchanger}.
 */

@Service
public class CurrencyExchangerImpl implements CurrencyExchanger {

    private final ExchangeRateProvider provider;

    @Autowired
    public CurrencyExchangerImpl(ExchangeRateProvider provider) {
        this.provider = provider;
    }

    @Override
    public void exchange(Product product, String currentCurrency, String targetCurrency) {

        product.setPrice(
            convert(product.getPrice(), currentCurrency, targetCurrency)
        );

        product.setCurrency(targetCurrency);
    }

    private BigDecimal convert(BigDecimal amount, String currentCurrency, String targetCurrency) {

        if (currentCurrency.equals(targetCurrency)) {
            return amount;
        }

        return amount.multiply(
            provider.provide(currentCurrency, targetCurrency)
        );
    }
}