package com.flameshine.store.service.impl;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flameshine.store.model.Currency;
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
    public BigDecimal exchange(BigDecimal amount, Currency current, Currency target) {

        if (current.equals(target)) {
            return amount;
        }

        return amount.multiply(
            getExchangeRate(current, target)
        );
    }

    private BigDecimal getExchangeRate(Currency current, Currency target) {

        var uri = URI.create(
            String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", accessKey, current, target
            )
        );

        var request = HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .build();

        String responseBody;
        try {
            responseBody = HttpUtils.send(request)
                .toCompletableFuture()
                .get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        return new BigDecimal(
            JsonUtils.extract(responseBody, "conversion_rate")
        );
    }
}