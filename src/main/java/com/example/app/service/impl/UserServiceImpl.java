package com.example.app.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.service.UserService;
import com.example.app.repository.UserRepository;
import com.example.app.entity.User;

/**
 * Implementation of {@link UserService}.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(repository.findAll());
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with id %d not found.", id)));
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }
}