package com.example.app.service;

import java.util.List;

import com.example.app.entity.Purchase;

/**
 * Service for the basic interactions with {@link com.example.app.entity.Purchase} entity.
 */

public interface PurchaseService {

    List<Purchase> findAll();

    void save(Purchase role);

    void deleteById(Long id);
}