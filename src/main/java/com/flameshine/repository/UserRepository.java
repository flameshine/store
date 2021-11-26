package com.flameshine.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.flameshine.entity.User;

/**
 * Repository that handles the {@link com.flameshine.entity.User} entity.
 */

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}