package com.flameshine.store.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

import com.flameshine.store.exception.ApplicationException;

/**
 * Utility for HTTP calls.
 */

@Component
public record HttpCaller(HttpClient client) {

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

        if (200 != statusCode) {
            throw new ApplicationException(
                String.format(
                    "An unexpected error has occurred during the HTTP call (status code: '%s', body: '%s')",
                    statusCode,
                    body
                )
            );
        }

        return body;
    }
}