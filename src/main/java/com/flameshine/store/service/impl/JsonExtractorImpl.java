package com.flameshine.store.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.flameshine.store.service.JsonExtractor;
import com.flameshine.store.exception.ApplicationException;

/**
 * Implementation of {@link com.flameshine.store.service.JsonExtractor}.
 */

@Service
public class JsonExtractorImpl implements JsonExtractor {

    private final ObjectMapper mapper;

    @Autowired
    public JsonExtractorImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String extractValue(String json, String key) {

        try {
            return mapper.readTree(json).get(key).toString();
        } catch (JsonProcessingException e) {
            throw new ApplicationException(
                String.format("Couldn't extract value from the JSON string ('%s')", json), e
            );
        }
    }
}