package com.example.app.service;

import java.util.List;
import java.util.Optional;

import com.example.app.entity.User;

/**
 * Service for the basic interactions with {@link com.example.app.entity.User} entity.
 */

public interface UserService {

    List<User> findAll();

    void save(User user);

    void deleteById(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}