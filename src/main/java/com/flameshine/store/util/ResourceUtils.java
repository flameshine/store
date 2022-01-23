package com.flameshine.store.util;

import java.util.List;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;

/**
 * Utility responsible for storing currencies list read from the static resource.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceUtils {

    public static List<String> readCurrencies() {

        var path = Paths.get("src/main/resources/static/currencies.txt");

        try {
            return List.copyOf(
                Files.readAllLines(path, StandardCharsets.UTF_8)
            );
        } catch (IOException e) {
            throw new UncheckedIOException(
                String.format("Couldn't read currencies from resource ('%s')", path), e
            );
        }
    }
}