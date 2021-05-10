package com.example.app.service.security;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final var optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            final var message = String.format("User with username %s not found.", username);
            throw new UsernameNotFoundException(message);
        }

        final var user = optionalUser.get();

        return new User(user.getUsername(), user.getPassword(), Set.of(new SimpleGrantedAuthority(user.getRole().getRoleName())));
    }
}