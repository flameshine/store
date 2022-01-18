package com.flameshine.store.service;

import java.net.http.HttpRequest;

/**x
 * Class responsible for HTTP calls.
 */

public interface HttpCaller {
    String call(HttpRequest request);
}