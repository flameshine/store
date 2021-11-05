package com.flameshine.app.service.impl.security;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.flameshine.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(
                String.format(
                    "User with username %s not found",
                    username
                ))
            );

        var grantedAuthority = new SimpleGrantedAuthority(
            user.getRole().getName()
        );

        return new User(
            user.getUsername(),
            user.getPassword(),
            Set.of(grantedAuthority)
        );
    }
}