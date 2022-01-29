package com.flameshine.store.security;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;

import com.flameshine.store.repository.UserRepository;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService}.
 */

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(
            repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                    String.format(
                        "User with username '%s' not found", username
                    )
                ))
        );
    }
}