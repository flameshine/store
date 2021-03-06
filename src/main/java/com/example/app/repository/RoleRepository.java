package com.example.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Role;

/**
 * Repository that manages the {@link com.example.app.entity.Role} entity.
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {}