package com.example.app.entity;

import java.util.Collection;
import java.io.Serializable;
import java.io.Serial;

import javax.persistence.*;

import lombok.*;

/**
 * The purchase entity.
 */

@Entity
@Table(name = "purchase")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase implements Serializable {

    @Serial
    private static final long serialVersionUID = 8300097387796927801L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PurchaseStatus purchaseStatus;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "purchase_product", joinColumns = @JoinColumn(name = "purchase", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product", referencedColumnName = "id"))
    private Collection<Product> products;

    private enum PurchaseStatus {
        REGISTERED,
        PAID,
        CANCELLED
    }
}