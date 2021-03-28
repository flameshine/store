package com.example.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/**
 * Category entity.
 */

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = -4767042454855773193L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "category_name", unique = true, nullable = false)
    private String categoryName;
}