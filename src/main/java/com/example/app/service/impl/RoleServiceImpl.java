package com.example.app.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.service.RoleService;
import com.example.app.repository.RoleRepository;
import com.example.app.entity.Role;

/**
 * Implementation of {@link com.example.app.service.RoleService}.
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return List.copyOf(repository.findAll());
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Role with id %d not found.", id)));
    }

    @Override
    public void save(Role role) {
        repository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}