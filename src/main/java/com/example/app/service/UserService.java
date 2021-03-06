package com.example.app.service;

import java.util.List;

import com.example.app.entity.User;

/**
 * Service for basic interactions with {@link com.example.app.entity.User} entity.
 */

public interface UserService {

    void save(User user);

    List<User> findAll();

    User findById(Long id);

    void delete(User user);
}