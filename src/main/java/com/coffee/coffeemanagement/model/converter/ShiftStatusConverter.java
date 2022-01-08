package com.coffee.coffeemanagement.model.converter;

import javax.persistence.AttributeConverter;

import com.coffee.coffeemanagement.model.enums.ShiftStatus;

public class ShiftStatusConverter implements AttributeConverter<ShiftStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ShiftStatus status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public ShiftStatus convertToEntityAttribute(Integer value) {
        return ShiftStatus.getShiftStatus(value);
    }

}
