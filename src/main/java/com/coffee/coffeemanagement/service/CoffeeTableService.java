package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.CoffeeTable;
import com.coffee.coffeemanagement.model.enums.TableStatus;

public interface CoffeeTableService {

    CoffeeTable saveTable(CoffeeTable table);

    List<CoffeeTable> getAllTable();

    CoffeeTable getTableById(long id);

    CoffeeTable updateTable(long id, CoffeeTable table);

    void deleteTable(long id);

    List<CoffeeTable> getTablesByArea(long areaId);

    List<CoffeeTable> getTablesByStatus(TableStatus status);

    void validateTable(CoffeeTable table);

}
