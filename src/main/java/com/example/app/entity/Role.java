package com.example.app.entity;

import java.io.Serial;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * The role entity.
 */

@Entity
@Table(name = "role")
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends Persistable {

    @Serial
    private static final long serialVersionUID = -9046155609265777496L;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}