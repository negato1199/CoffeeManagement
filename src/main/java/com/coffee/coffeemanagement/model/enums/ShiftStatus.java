package com.coffee.coffeemanagement.model.enums;

import lombok.Getter;

@Getter
public enum ShiftStatus {
    WORK(0), OFF(1), LATE(2), OFF_SOON(3);

    private int value;

    private ShiftStatus(int value) {
        this.value = value;
    }

    public static ShiftStatus getShiftStatus(Integer value) {
        if (value == null)
            return null;
        for (ShiftStatus g : values()) {
            if (g.getValue() == value)
                return g;
        }
        return null;
    }
}
