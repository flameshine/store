package com.example.app.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * The product entity.
 */

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -5240415785520578477L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank(message = "Product name is required")
    @Length(min = 5, max = 15, message = "Product name must be between 5 and 15 characters")
    private String name;

    @Column(name = "description", unique = true, nullable = false)
    @Min(value = 5, message = "Product description must be greater than 5 characters")
    private String description;

    @Column(name = "price", nullable = false)
    @NotBlank(message = "Price is required.")
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    @NotBlank(message = "Quantity is required")
    private Integer quantity;
}