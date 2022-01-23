package com.flameshine.store.util;

import java.io.UncheckedIOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

/**
 * Utility responsible for extracting a value by key from the JSON string.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String extract(String json, String key) {

        try {
            return MAPPER.readTree(json).get(key).asText();
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(
                String.format("Couldn't extract value from the JSON string ('%s')", json), e
            );
        }
    }
}