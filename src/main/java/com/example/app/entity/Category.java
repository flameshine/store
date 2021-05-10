package com.example.app.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * The category entity.
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
    @NotBlank(message = "Category name is required.")
    @Length(min = 5, max = 15, message = "Category name must be between 5 and 15 characters.")
    private String categoryName;
}