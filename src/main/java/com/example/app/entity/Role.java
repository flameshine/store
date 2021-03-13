package com.example.app.entity;

import javax.persistence.*;

import lombok.*;

/**
 * Role entity.
 */

@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends Persistable {

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;
}