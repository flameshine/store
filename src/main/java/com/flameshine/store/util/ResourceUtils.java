package com.flameshine.store.util;

import java.util.List;
import java.util.ArrayList;
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

        List<String> result = new ArrayList<>();

        var path = String.join(
            File.separator, File.separator + "static", "currencies.txt"
        );

        try (
            var reader = new BufferedReader(
                new InputStreamReader(
                    Objects.requireNonNull(ResourceUtils.class.getResourceAsStream(path))
                )
            )
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            throw new UncheckedIOException(
                String.format("Couldn't read currencies from the resource ('%s')", path), e
            );
        }

        return List.copyOf(result);
    }
}