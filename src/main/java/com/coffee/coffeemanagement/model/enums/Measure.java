package com.coffee.coffeemanagement.model.enums;

import lombok.Getter;

@Getter
public enum Measure {
    KHOI_LUONG(0, "Kg"), THE_TICH(1, "L"), DON_VI(2, "Unit");

    private int value;

    private String name;

    private Measure(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Measure getMeasuer(Integer value) {
        if (value == null)
            return null;
        for (Measure g : values()) {
            if (g.getValue() == value)
                return g;
        }
        return null;
    }

}
