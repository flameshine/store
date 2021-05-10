package com.example.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/**
 * The role entity.
 */

@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 2431567030846691089L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;
}