package com.example.app.entity;

import java.util.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.io.Serial;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    @NotBlank(message = "Product name is required.")
    @Length(min = 5, max = 15, message = "Product name must be between 5 and 15 characters.")
    private String name;

    @Column(name = "price", nullable = false)
    @NotBlank(message = "Price is required.")
    private BigDecimal price;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "addition_date", nullable = false)
    private Date additionDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date", nullable = false)
    private Date modifyDate;

    @Column(name = "quantity", nullable = false)
    @NotBlank(message = "Quantity is required.")
    private Integer quantity;

    @Column(name = "reserve", nullable = false)
    @NotBlank(message = "Reserve name is required.")
    private Integer reserve;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "products")
    private Collection<Purchase> purchases;
}