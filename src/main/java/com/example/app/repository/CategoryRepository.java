package com.example.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Category;

/**
 * Repository that handles the {@link com.example.app.entity.Category} entity.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}