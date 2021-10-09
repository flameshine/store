package com.example.app.util;

import org.springframework.data.domain.Page;

import com.example.app.entity.Product;

/**
 * An auxiliary utility for working with pages.
 */

public record Pager(Page<Product> products) {

    public int getPageIndex() {
        return products.getNumber() + 1;
    }

    public int getPageSize() {
        return products.getSize();
    }

    public boolean hasNext() {
        return products.hasNext();
    }

    public boolean hasPrevious() {
        return products.hasPrevious();
    }

    public int getTotalPages() {
        return products.getTotalPages();
    }

    public boolean isIndexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > products.getTotalElements();
    }
}