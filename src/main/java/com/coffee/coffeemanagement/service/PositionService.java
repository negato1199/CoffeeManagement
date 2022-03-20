package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.Position;

public interface PositionService {
    Position savePosition(Position position);

    List<Position> getAllPositions();

    Position getPositionById(long id);

    Position updatePosition(long id, Position position);

    void deletePosition(long id);

    List<Position> getPositionsByName(String name);

    void validatePosition(Position position);

    void checkDuplicatePosition(Position position);
}
