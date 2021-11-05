package com.flameshine.app.entity;

import java.io.Serializable;
import java.io.Serial;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The base entity.
 */

@MappedSuperclass
@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class Persistable implements Serializable {

    @Serial
    private static final long serialVersionUID = -3981279827927432839L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
}