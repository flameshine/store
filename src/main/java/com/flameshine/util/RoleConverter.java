package com.flameshine.util;

import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

import com.flameshine.model.Role;

/**
 * Converter for user roles.
 */

@Converter
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        return "ROLE_" + role.name();
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return Role.valueOf(
            dbData.substring(5)
        );
    }
}