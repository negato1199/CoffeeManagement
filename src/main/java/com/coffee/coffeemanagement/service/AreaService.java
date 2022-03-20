package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.Area;

public interface AreaService {

    Area saveArea(Area area);

    List<Area> getAllAreas();

    Area getAreaById(long id);

    Area updateArea(long id, Area area);

    void deleteArea(long id);

    List<Area> getAreaByName(String name);

    void validateArea(Area area);

    void checkDuplicateArea(Area area);
}
