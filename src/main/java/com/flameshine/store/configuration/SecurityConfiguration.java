package com.flameshine.store.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.flameshine.store.util.Constants;
import com.flameshine.store.model.Role;

/**
 * Configuration class for the application security.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService service;

    @Autowired
    public SecurityConfiguration(UserDetailsService service) {
        this.service = service;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers(Constants.USERS_PATH)
            .hasRole(Role.ADMIN.name())
            .antMatchers(Constants.REGISTRATION_PATH, Constants.ERROR_PATH)
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage(Constants.LOGIN_PATH)
            .defaultSuccessUrl(Constants.HOME_PATH)
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) {
        managerBuilder.authenticationProvider(authenticationProviderBean());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProviderBean() {

        var authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(service);
        authenticationProvider.setPasswordEncoder(passwordEncoderBean());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }
}