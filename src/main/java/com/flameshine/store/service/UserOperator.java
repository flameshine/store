package com.flameshine.store.service;

import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.flameshine.store.entity.User;

/**
 * Responsible for operating with the {@link com.flameshine.store.entity.User} entity.
 */

public interface UserOperator {

    void save(User user);

    Iterable<User> findAll(Sort criterion);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}