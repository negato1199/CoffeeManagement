package com.coffee.coffeemanagement.model.converter;

import javax.persistence.AttributeConverter;

import com.coffee.coffeemanagement.model.enums.DrinkStage;

public class DrinkStageConverter implements AttributeConverter<DrinkStage, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DrinkStage drinkStage) {
        if (drinkStage == null)
            return null;
        return drinkStage.getValue();
    }

    @Override
    public DrinkStage convertToEntityAttribute(Integer value) {
        return DrinkStage.getDrinkStage(value);
    }

}
