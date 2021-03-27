package com.example.app.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.*;

/**
 * Product entity.
 */

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends Persistable implements Serializable {

    private static final long serialVersionUID = -5240415785520578477L;

    @Column(name = "product_name", unique = true, nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
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
    private Integer quantity;

    @Column(name = "reserve", nullable = false)
    private Integer reserve;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;
}