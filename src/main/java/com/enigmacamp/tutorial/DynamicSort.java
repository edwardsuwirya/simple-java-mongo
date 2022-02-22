package com.enigmacamp.tutorial;

import org.springframework.data.domain.Sort;

public class DynamicSort {
    private Sort.Direction direction;
    private String fieldName;

    DynamicSort(String fieldName, Sort.Direction direction) {
        this.fieldName = fieldName;
        this.direction = direction;
    }

    public Sort sort() {
        return Sort.by(direction, fieldName);
    }
}
