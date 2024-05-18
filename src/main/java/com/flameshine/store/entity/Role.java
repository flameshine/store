package com.flameshine.store.entity;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

/**
 * Enumeration that represents user roles.
 */

@RequiredArgsConstructor
@Getter
public enum Role {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String code;
}