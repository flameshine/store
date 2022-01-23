package com.flameshine.store.storage;

import java.util.List;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

/**
 * Class responsible for storing currencies list read from the static resource.
 */

@Component
public class CurrencyStorage {

    private final List<String> currencies;

    public CurrencyStorage() {
        this.currencies = readCurrencies();
    }

    public List<String> getCurrencies() {
        return List.copyOf(currencies);
    }

    private List<String> readCurrencies() {

        var path = Paths.get("src/main/resources/static/currencies.txt");

        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(
                String.format("Couldn't read currencies ('%s')", path), e
            );
        }
    }
}