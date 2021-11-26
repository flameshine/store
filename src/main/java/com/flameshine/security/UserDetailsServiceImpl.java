package com.flameshine.security;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.flameshine.repository.UserRepository;

/**
 * Implementation of {@link UserDetailsService}.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(
            repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                    String.format(
                        "User with username %s not found",
                        username
                    ))
                )
        );
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}