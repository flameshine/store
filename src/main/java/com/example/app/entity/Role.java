package com.example.app.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

/**
 * Role entity.
 */

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<User> users;
}