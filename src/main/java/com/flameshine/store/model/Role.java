package com.flameshine.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration that represents user roles.
 */

@AllArgsConstructor
@Getter
public enum Role {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String code;
}