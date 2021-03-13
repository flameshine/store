package com.example.app.entity;

import javax.persistence.*;

import lombok.Data;

/**
 * Mapped superclass that contains common fields for other entities.
 */

@Data
@MappedSuperclass
public class Persistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
}