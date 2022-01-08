package com.coffee.coffeemanagement.model.converter;

import javax.persistence.AttributeConverter;

import com.coffee.coffeemanagement.model.enums.Status;

public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer value) {
        return Status.getStatus(value);
    }

}
