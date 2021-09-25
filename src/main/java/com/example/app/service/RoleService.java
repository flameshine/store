package com.example.app.service;

import java.util.List;

import com.example.app.entity.Role;

/**
 * Service for the basic interactions with {@link com.example.app.entity.Role} entity.
 */

public interface RoleService {

    void save(Role role);

    List<Role> findAll();

    void deleteById(Long id);
}