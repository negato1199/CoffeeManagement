package com.coffee.coffeemanagement.service.impl;

import java.util.List;

import com.coffee.coffeemanagement.exception.DuplicatedException;
import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.Position;
import com.coffee.coffeemanagement.repository.PositionRepository;
import com.coffee.coffeemanagement.service.PositionService;

import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        super();
        this.positionRepository = positionRepository;
    }

    @Override
    public Position savePosition(Position position) {
        validatePosition(position);
        checkDuplicatePosition(position);
        return positionRepository.save(position);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position getPositionById(long id) {
        return positionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position", "Id", id));
    }

    @Override
    public Position updatePosition(long id, Position position) {
        validatePosition(position);
        Position existingPosition = getPositionById(id);
        existingPosition.setName(position.getName());
        existingPosition.setCoefficient(position.getCoefficient());
        positionRepository.save(existingPosition);
        return existingPosition;
    }

    @Override
    public void deletePosition(long id) {
        getPositionById(id);
        positionRepository.deleteById(id);
    }

    @Override
    public List<Position> getPositionsByName(String name) {
        return positionRepository.getPositionsByName(name);
    }

    @Override
    public void validatePosition(Position position) {
        if (position.getName().isBlank())
            throw new EmptyInputException("601", "Input Fields are empty");
    }

    @Override
    public void checkDuplicatePosition(Position position) {
        List<Position> positions = getPositionsByName(position.getName());
        if (!positions.isEmpty())
            throw new DuplicatedException("409", "This item is already existed");
    }

}
