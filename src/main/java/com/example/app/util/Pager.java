package com.example.app.util;

import org.springframework.data.domain.Page;

/**
 * An auxiliary utility for items that need pagination.
 */

public record Pager(Page<?> items) {

    public int getPageIndex() {
        return items.getNumber() + 1;
    }

    public int getPageSize() {
        return items.getSize();
    }

    public boolean hasNext() {
        return items.hasNext();
    }

    public boolean hasPrevious() {
        return items.hasPrevious();
    }

    public int getTotalPages() {
        return items.getTotalPages();
    }

    public boolean isIndexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > items.getTotalElements();
    }
}