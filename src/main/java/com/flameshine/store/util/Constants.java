package com.flameshine.store.util;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;

/**
 * Auxiliary utility that stores all constants.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

    public static final String REGISTRATION_PATH = "/registration";
    public static final String LOGIN_PATH = "/login";
    public static final String HOME_PATH = "/home";
    public static final String PRODUCTS_PATH = "/products";
    public static final String CART_PATH = "/cart";
    public static final String USERS_PATH = "/users";
    public static final String ERROR_PATH = "/error";
}