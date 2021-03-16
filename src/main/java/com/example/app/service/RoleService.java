package com.example.app.service;

import java.util.List;

import com.example.app.entity.Role;

/**
 * Service for basic interactions with {@link com.example.app.entity.Role} entity.
 */

public interface RoleService {

    List<Role> findAll();

    Role findById(Long id);

    void save(Role role);

    void deleteById(Long id);
}