package com.flameshine.store.util;

import java.math.BigDecimal;
import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flameshine.store.model.Currency;

/**
 * Utility for currency conversion.
 */

@Component
public record CurrencyConverter(HttpCaller caller, JsonExtractor extractor, String accessKey) {

    private static final String URL_FORMAT = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s";

    @Autowired
    public CurrencyConverter(
        HttpCaller caller,
        JsonExtractor extractor,
        @Value("${converter.access-key}") String accessKey
    ) {
        this.caller = caller;
        this.extractor = extractor;
        this.accessKey = accessKey;
    }

    public BigDecimal convert(BigDecimal amount, Currency from, Currency to) {

        if (from == to) {
            return amount;
        }

        return amount.multiply(
            getRate(from, to)
        );
    }

    private BigDecimal getRate(Currency from, Currency to) {

        var uri = URI.create(
            String.format(URL_FORMAT, accessKey, from.name(), to.name())
        );

        return new BigDecimal(
            extractor.extractValue(caller.call(uri), "conversion_rate")
        );
    }
}