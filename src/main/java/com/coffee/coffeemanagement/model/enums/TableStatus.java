package com.coffee.coffeemanagement.model.enums;

import lombok.Getter;

@Getter
public enum TableStatus {
    EMPTY(0), FULL(1), BOOKED(2);

    private int value;

    private TableStatus(int value) {
        this.value = value;
    }

    public static TableStatus getTableStatus(Integer value) {
        if (value == null)
            return null;
        for (TableStatus g : values()) {
            if (g.getValue() == value)
                return g;
        }
        return null;
    }

}
