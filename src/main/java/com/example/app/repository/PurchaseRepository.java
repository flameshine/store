package com.example.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Purchase;

/**
 * Repository that handles the {@link com.example.app.entity.Purchase} entity.
 */

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {}