package com.flameshine.app.security;

import java.util.Collection;
import java.util.List;
import java.io.Serial;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.flameshine.app.entity.User;

/**
 * Implementation of {@link UserDetails}.
 */

public record UserDetailsImpl(User user) implements UserDetails {

    @Serial
    private static final long serialVersionUID = -5188993240437093408L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
            new SimpleGrantedAuthority(
                user.getRole().getName()
            )
        );
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled();
    }
}