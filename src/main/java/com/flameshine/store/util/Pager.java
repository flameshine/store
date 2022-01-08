package com.flameshine.store.util;

import org.springframework.data.domain.Page;

/**
 * Auxiliary utility for items that need pagination.
 */

public record Pager(Page<?> items) {

    public boolean hasNext() {
        return items.hasNext();
    }

    public boolean hasPrevious() {
        return items.hasPrevious();
    }

    public int getTotalPages() {
        return items.getTotalPages();
    }
}