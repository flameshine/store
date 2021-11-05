package com.flameshine.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.app.entity.User;

/**
 * Service for the basic interactions with {@link com.flameshine.app.entity.User} entity.
 */

public interface UserService {

    void save(User user);

    Page<User> findAllPageable(Pageable pageable);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void deleteById(Long id);
}