package com.example.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

/**
 * Mapped superclass that contains common fields for other entities.
 */

@Data
@MappedSuperclass
public class Persistable implements Serializable {

    private static final long serialVersionUID = -489955066772567663L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
}