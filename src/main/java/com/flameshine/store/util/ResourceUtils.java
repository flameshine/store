package com.flameshine.store.util;

import java.util.List;
import java.util.Objects;
import java.io.*;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;

/**
 * Utility responsible for loading data from static resources.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceUtils {

    public static List<String> loadCurrencies() {

        var path = String.join(
            File.separator, File.separator + "static", "currencies.txt"
        );

        try (
            var reader = new BufferedReader(
                new InputStreamReader(
                    Objects.requireNonNull(
                        ResourceUtils.class.getResourceAsStream(path)
                    )
                )
            )
        ) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new UncheckedIOException(
                String.format("Couldn't read currencies from the resource ('%s')", path), e
            );
        }
    }
}