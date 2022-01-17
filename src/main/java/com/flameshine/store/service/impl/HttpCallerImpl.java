package com.flameshine.store.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.flameshine.store.service.HttpCaller;
import com.flameshine.store.exception.ApplicationException;

/**
 * Implementation of {@link com.flameshine.store.service.HttpCaller}.
 */

@Service
public class HttpCallerImpl implements HttpCaller {

    private final HttpClient client;

    @Autowired
    public HttpCallerImpl(HttpClient client) {
        this.client = client;
    }

    @Override
    public String call(URI uri) {

        var request = HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ApplicationException("An unexpected error has occurred during the HTTP call", e);
        }

        var statusCode = response.statusCode();
        var body = response.body();

        if (HttpStatus.OK.value() != statusCode) {
            throw new ApplicationException(
                String.format(
                    "An unexpected error has occurred during the HTTP call (status code: '%s', body: '%s')", statusCode, body
                )
            );
        }

        return body;
    }
}