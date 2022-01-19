package com.flameshine.store.service.impl;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.flameshine.store.service.HttpCaller;

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
    public String call(HttpRequest request) {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(this::handle)
            .join();
    }

    private String handle(HttpResponse<String> response) {

        var statusCode = response.statusCode();
        var body = response.body();

        if (HttpStatus.OK.value() != statusCode) {
            throw new IllegalStateException(
                String.format(
                    "An unexpected error has occurred during the HTTP call (status code: '%d', body: '%s')", statusCode, body
                )
            );
        }

        return body;
    }
}
