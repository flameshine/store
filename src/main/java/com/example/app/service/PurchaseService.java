package com.example.app.service;

import java.util.List;

import com.example.app.entity.Purchase;

/**
 * Service for the basic interactions with {@link com.example.app.entity.Purchase} entity.
 */

public interface PurchaseService {

    void save(Purchase role);

    List<Purchase> findAll();

    void deleteById(Long id);
}