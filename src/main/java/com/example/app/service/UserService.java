package com.example.app.service;

import java.util.List;

import com.example.app.entity.User;

/**
 * Service for the basic interactions with {@link com.example.app.entity.User} entity.
 */

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);
}