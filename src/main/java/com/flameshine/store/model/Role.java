package com.flameshine.store.model;

/**
 * Enumeration that represents user roles.
 */

public enum Role {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String code;

    Role(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}