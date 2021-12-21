package com.flameshine.entity;

import java.io.Serial;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;
import lombok.experimental.SuperBuilder;

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