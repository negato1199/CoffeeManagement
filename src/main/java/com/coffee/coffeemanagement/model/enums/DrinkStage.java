package com.coffee.coffeemanagement.model.enums;

import lombok.Getter;

@Getter
public enum DrinkStage {
    HOT(0), COLD(1);

    private int value;

    private DrinkStage(int value) {
        this.value = value;
    }

    public static DrinkStage getDrinkStage(Integer value) {
        if (value == null)
            return null;
        for (DrinkStage g : values()) {
            if (g.getValue() == value)
                return g;
        }
        return null;
    }
}
