package com.coffee.coffeemanagement.model.converter;

import javax.persistence.AttributeConverter;

import com.coffee.coffeemanagement.model.enums.TableStatus;

public class TableStatusConverter implements AttributeConverter<TableStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TableStatus status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public TableStatus convertToEntityAttribute(Integer value) {
        return TableStatus.getTableStatus(value);
    }

}
