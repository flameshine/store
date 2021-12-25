package com.flameshine.entity;

import java.io.Serial;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The user entity.
 */

@Entity
@Table(name = "user")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends Persistable {

    @Serial
    private static final long serialVersionUID = 4756172225734787914L;

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
    private Boolean isEnabled;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    private Role role;
}