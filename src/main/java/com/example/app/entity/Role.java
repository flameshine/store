package com.example.app.entity;

import java.io.Serializable;

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
public class Role extends Persistable implements Serializable {

    private static final long serialVersionUID = 2431567030846691089L;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;
}