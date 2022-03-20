package com.coffee.coffeemanagement.service.impl;

import java.util.List;

import com.coffee.coffeemanagement.exception.DuplicatedException;
import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.Area;
import com.coffee.coffeemanagement.repository.AreaRepository;
import com.coffee.coffeemanagement.service.AreaService;

import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

    private AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        super();
        this.areaRepository = areaRepository;
    }

    @Override
    public Area saveArea(Area area) {
        validateArea(area);
        checkDuplicateArea(area);
        return areaRepository.save(area);
    }

    @Override
    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    @Override
    public Area getAreaById(long id) {
        return areaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area", "Id", id));
    }

    @Override
    public Area updateArea(long id, Area area) {
        validateArea(area);
        Area existingArea = getAreaById(id);
        existingArea.setName(area.getName());
        areaRepository.save(existingArea);
        return existingArea;
    }

    @Override
    public void deleteArea(long id) {
        getAreaById(id);
        areaRepository.deleteById(id);
    }

    @Override
    public List<Area> getAreaByName(String name) {
        return areaRepository.getAreaByName(name);
    }

    @Override
    public void validateArea(Area area) {
        if (area.getName().isBlank()) {
            throw new EmptyInputException("601", "Input Fields are empty");
        }
    }

    @Override
    public void checkDuplicateArea(Area area) {
        List<Area> areas = getAreaByName(area.getName());
        if (!areas.isEmpty())
            throw new DuplicatedException("409", "This item is already existed");
    }

}
