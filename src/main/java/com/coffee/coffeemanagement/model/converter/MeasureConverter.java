package com.coffee.coffeemanagement.model.converter;

import javax.persistence.AttributeConverter;

import com.coffee.coffeemanagement.model.enums.Measure;

public class MeasureConverter implements AttributeConverter<Measure, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Measure measure) {
        if (measure == null)
            return null;
        return measure.getValue();
    }

    @Override
    public Measure convertToEntityAttribute(Integer value) {
        return Measure.getMeasuer(value);
    }

}
