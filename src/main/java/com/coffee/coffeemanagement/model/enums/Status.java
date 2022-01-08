package com.coffee.coffeemanagement.model.enums;

import lombok.Getter;

@Getter
public enum Status {
    NOT_PAID(0), PAID(1);

    private int value;

    private Status(int value) {
        this.value = value;
    }

    public static Status getStatus(Integer value) {
        if (value == null)
            return null;
        for (Status g : values()) {
            if (g.getValue() == value)
                return g;
        }
        return null;
    }
}
