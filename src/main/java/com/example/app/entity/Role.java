package com.example.app.entity;

import java.io.Serializable;
import java.io.Serial;

import javax.persistence.*;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * The role entity.
 */

@Entity
@Table(name = "role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 2431567030846691089L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}