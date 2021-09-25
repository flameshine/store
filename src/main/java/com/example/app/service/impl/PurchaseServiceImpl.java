package com.example.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.service.PurchaseService;
import com.example.app.repository.PurchaseRepository;
import com.example.app.entity.Purchase;

/**
 * Implementation of {@link com.example.app.service.PurchaseService}.
 */

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository repository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Purchase category) {
        repository.save(category);
    }

    @Override
    public List<Purchase> findAll() {
        return List.copyOf(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}