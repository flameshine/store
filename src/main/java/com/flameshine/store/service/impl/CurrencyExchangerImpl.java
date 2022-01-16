package com.flameshine.store.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.flameshine.store.service.CurrencyExchanger;
import com.flameshine.store.service.ExchangeRateProvider;
import com.flameshine.store.entity.Product;
import com.flameshine.store.model.Currency;

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
    public void exchange(Product product, Currency currency) {

        product.setPrice(
            convert(
                product.getPrice(), product.getCurrency(), currency
            )
        );

        product.setCurrency(
            currency
        );
    }

    private BigDecimal convert(BigDecimal amount, Currency from, Currency to) {

        if (from == to) {
            return amount;
        }

        return amount.multiply(
            provider.provide(from, to)
        );
    }
}