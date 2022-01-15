package com.flameshine.store.util;

import java.io.UncheckedIOException;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Utility that extracts value by key from JSON string.
 */

@Component
public record JsonExtractor(ObjectMapper mapper) {

    public String extractValue(String json, String key) {

        try {
            return mapper.readTree(json).get(key).toString();
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }
}