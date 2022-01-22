package com.flameshine.store.service.impl;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpRequest;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flameshine.store.service.ExchangeRateProvider;
import com.flameshine.store.service.HttpCaller;
import com.flameshine.store.service.JsonExtractor;
import com.flameshine.store.model.Currency;

/**
 * Implementation of {@link com.flameshine.store.service.ExchangeRateProvider}.
 */

@Service
public class ExchangeRateProviderImpl implements ExchangeRateProvider {

    private static final String URL_FORMAT = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s";

    private final HttpCaller caller;
    private final JsonExtractor extractor;
    private final String accessKey;

    @Autowired
    public ExchangeRateProviderImpl(
        HttpCaller caller,
        JsonExtractor extractor,
        @Value("${exchange-rate-provider.access-key}") String accessKey
    ) {
        this.caller = caller;
        this.extractor = extractor;
        this.accessKey = accessKey;
    }

    @Override
    public BigDecimal provide(Currency from, Currency to) {

        var uri = URI.create(
            String.format(URL_FORMAT, accessKey, from.name(), to.name())
        );

        var request = HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .build();

        return new BigDecimal(
            extractor.extract(caller.call(request), "conversion_rate")
        );
    }
}