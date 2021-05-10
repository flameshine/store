package com.example.app.service.impl.security;

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
            final var message = String.format("User with the username %s not found.", username);
            throw new UsernameNotFoundException(message);
        }

        final var user = optionalUser.get();

        final var grantedAuthority = new SimpleGrantedAuthority(user.getRole().getRoleName());

        return new User(user.getUsername(), user.getPassword(), Set.of(grantedAuthority));
    }
}