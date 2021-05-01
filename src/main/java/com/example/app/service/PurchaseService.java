package com.example.app.service;

import java.util.List;

import com.example.app.entity.Purchase;

/**
 * Service for the basic interactions with {@link com.example.app.entity.Purchase} entity.
 */

public interface PurchaseService {

    List<Purchase> findAll();

    Purchase findById(Long id);

    void save(Purchase role);

    void deleteById(Long id);
}