package com.coffee.coffeemanagement.model.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE(0), FEMALE(1), OTHER(2);

    private int value;

    private Gender(int value) {
        this.value = value;
    }

    public static Gender getGender(Integer value) {
        if (value == null)
            return null;
        for (Gender g : values()) {
            if (g.getValue() == value)
                return g;
        }
        return null;
    }
}
