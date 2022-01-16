package com.flameshine.store.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.flameshine.store.service.UserOperator;
import com.flameshine.store.repository.UserRepository;
import com.flameshine.store.entity.User;

/**
 * Implementation of {@link com.flameshine.store.service.UserOperator}.
 */

@Service
@Transactional
public class UserOperatorImpl implements UserOperator {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserOperatorImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void save(User user) {

        user.setPassword(
            encoder.encode(user.getPassword())
        );

        repository.save(user);
    }

    @Override
    public Page<User> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}