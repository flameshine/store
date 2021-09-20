package com.example.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.app.entity.User;

/**
 * Service for the basic interactions with {@link com.example.app.entity.User} entity.
 */

public interface UserService {

    Page<User> findAllPageable(Pageable pageable);

    void save(User user);

    void deleteById(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}