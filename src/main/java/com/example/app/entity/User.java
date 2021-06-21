package com.example.app.entity;

import java.io.Serializable;
import java.io.Serial;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The user entity.
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
    protected Long id;

    @Column(name = "username", unique = true, nullable = false)
    @NotBlank(message = "Username is required.")
    @Length(min = 5, max = 15, message = "Username must be between 5 and 15 characters.")
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Provide a valid email.")
    private String email;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is required.")
    @Length(min = 5, message = "Password must be greater than 5 characters.")
    private String password;

    @Transient
    @JsonIgnore
    @NotBlank(message = "Password confirmation is required.")
    private String passwordConfirmation;

    @Column(name = "firstname", nullable = false)
    @NotBlank(message = "First name is required.")
    private String firstname;

    @Column(name = "lastname", nullable = false)
    @NotBlank(message = "Last name is required.")
    private String lastname;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    private Role role;
}