package com.flameshine.store.service;

/**
 * Class that extracts value by key from the JSON string.
 */

public interface JsonExtractor {
    String extractValue(String json, String key);
}