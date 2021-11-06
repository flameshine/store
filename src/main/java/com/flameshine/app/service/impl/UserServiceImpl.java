package com.flameshine.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.flameshine.app.service.UserService;
import com.flameshine.app.repository.UserRepository;
import com.flameshine.app.entity.User;
import com.flameshine.app.entity.Role;

/**
 * Implementation of {@link UserService}.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User user) {

        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );

        user.setIsEnabled(Boolean.TRUE);

        var role = Role.builder()
            .id(1L)
            .name("ROLE_USER")
            .build();

        user.setRole(role);

        userRepository.save(user);
    }

    @Override
    public Page<User> findAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}