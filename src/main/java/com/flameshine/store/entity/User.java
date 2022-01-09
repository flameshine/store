package com.flameshine.store.entity;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.flameshine.store.model.Role;

/**
 * User entity.
 */

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 4756172225734787914L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    @NotBlank(message = "Username is required")
    @Length(min = 5, max = 15, message = "Username must be between 5 and 15 characters")
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is required")
    @Length(min = 5, message = "Password must be greater than 5 characters")
    private String password;

    @JsonIgnore
    @Transient
    @NotBlank(message = "Password confirmation is required")
    private String passwordConfirmation;

    @Column(name = "firstname", nullable = false)
    @NotBlank(message = "First name is required")
    private String firstname;

    @Column(name = "lastname", nullable = false)
    @NotBlank(message = "Last name is required")
    private String lastname;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Provide a valid email")
    private String email;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled = Boolean.TRUE;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
}