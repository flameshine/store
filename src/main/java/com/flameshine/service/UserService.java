package com.flameshine.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.entity.User;

/**
 * Service for the basic interactions with {@link com.flameshine.entity.User} entity.
 */

public interface UserService {

    void save(User user);

    Page<User> findAllPageable(Pageable pageable);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}