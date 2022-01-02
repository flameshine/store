package com.flameshine.entity;

import java.math.BigDecimal;
import java.io.Serial;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Product entity.
 */

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -5240415785520578477L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank(message = "Product name is required")
    private String name;

    @Column(name = "description", unique = true, nullable = false)
    @NotBlank(message = "Product description is required")
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price is required.")
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "Quantity is required")
    private Integer quantity;
}