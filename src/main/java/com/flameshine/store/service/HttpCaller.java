package com.flameshine.store.service;

import java.net.URI;

/**
 * Class responsible for HTTP calls.
 */

public interface HttpCaller {
    String call(URI uri);
}