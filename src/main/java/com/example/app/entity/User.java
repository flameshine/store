package com.example.app.entity;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * User entity.
 */

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @Transient
    private String confirmationPassword;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}