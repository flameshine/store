package com.flameshine.entity;

import java.io.Serial;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

/**
 * The product entity.
 */

@Entity
@Table(name = "product")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends Persistable {

    @Serial
    private static final long serialVersionUID = -5240415785520578477L;

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