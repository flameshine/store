package com.example.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.User;

/**
 * Repository that manages the {@link com.example.app.entity.User} entity.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}