package com.example.app.entity;

import java.util.Collection;
import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/**
 * The purchase entity.
 */

@Data
@Entity
@Table(name = "purchase")
@NoArgsConstructor
@AllArgsConstructor
public class Purchase implements Serializable {

    private static final long serialVersionUID = 8300097387796927801L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", unique = true, nullable = false)
    protected Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PurchaseStatus purchaseStatus;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "purchase_product", joinColumns = @JoinColumn(name = "purchase_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Collection<Product> products;
}