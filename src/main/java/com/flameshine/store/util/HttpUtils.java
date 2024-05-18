package com.flameshine.store.util;

import java.util.concurrent.CompletionStage;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

/**x
 * Utility responsible for HTTP interactions.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HttpUtils {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static CompletionStage<String> send(HttpRequest request) {
        return CLIENT.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpUtils::handleHttpResponse);
    }

    private static String handleHttpResponse(HttpResponse<String> httpResponse) {

        var statusCode = httpResponse.statusCode();
        var body = httpResponse.body();

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