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

        var optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            var message = String.format("User with the username %s not found.", username);
            throw new UsernameNotFoundException(message);
        }

        var user = optionalUser.get();

        var roleName = user.getRole().getName();

        var grantedAuthority = new SimpleGrantedAuthority(roleName);

        return new User(user.getUsername(), user.getPassword(), Set.of(grantedAuthority));
    }
}