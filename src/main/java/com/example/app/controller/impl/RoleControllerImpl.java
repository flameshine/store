package com.example.app.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.controller.RoleController;
import com.example.app.service.RoleService;
import com.example.app.entity.Role;

/**
 * Implementation of {@link com.example.app.controller.RoleController}.
 */

@RestController
public class RoleControllerImpl implements RoleController {

    private final RoleService service;

    @Autowired
    public RoleControllerImpl(RoleService service) {
        this.service = service;
    }

    @Override
    public List<Role> findAll() {
        return service.findAll();
    }

    @Override
    public Role findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(Role role) {
        service.save(role);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}