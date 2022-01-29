package com.flameshine.store.service.impl;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpRequest;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flameshine.store.service.CurrencyExchanger;
import com.flameshine.store.util.HttpUtils;
import com.flameshine.store.util.JsonUtils;

/**
 * Implementation of {@link com.flameshine.store.service.CurrencyExchanger}.
 */

@Service
public class CurrencyExchangerImpl implements CurrencyExchanger {

    private final String accessKey;

    @Autowired
    public CurrencyExchangerImpl(
        @Value("${currency-exchanger.access-key}") String accessKey
    ) {
        this.accessKey = accessKey;
    }

    @Override
    public BigDecimal exchange(BigDecimal amount, String currentCurrency, String targetCurrency) {

        if (currentCurrency.equals(targetCurrency)) {
            return amount;
        }

        return amount.multiply(
            getExchangeRate(currentCurrency, targetCurrency)
        );
    }

    private BigDecimal getExchangeRate(String currentCurrency, String targetCurrency) {

        var uri = URI.create(
            String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", accessKey, currentCurrency, targetCurrency)
        );

        var request = HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .build();

        var response = HttpUtils.send(request)
            .toCompletableFuture()
            .join();

        return new BigDecimal(
            JsonUtils.extract(response.body(), "conversion_rate")
        );
    }
}