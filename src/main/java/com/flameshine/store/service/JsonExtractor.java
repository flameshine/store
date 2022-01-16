package com.flameshine.store.service;

/**
 * Class responsible for extracting a value by key from the JSON string.
 */

public interface JsonExtractor {
    String extractValue(String json, String key);
}