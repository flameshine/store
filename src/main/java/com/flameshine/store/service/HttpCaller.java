package com.flameshine.store.service;

import java.net.URI;

/**
 * Class that calls the given URL via HTTP.
 */

public interface HttpCaller {
    String call(URI uri);
}