package com.coffee.coffeemanagement.service.impl;

import java.util.List;
import java.util.Objects;

import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.CoffeeTable;
import com.coffee.coffeemanagement.model.enums.TableStatus;
import com.coffee.coffeemanagement.repository.CoffeeTableRepository;
import com.coffee.coffeemanagement.service.CoffeeTableService;

import org.springframework.stereotype.Service;

@Service
public class CoffeeTableServiceImpl implements CoffeeTableService {

    private CoffeeTableRepository coffeeTableRepository;

    public CoffeeTableServiceImpl(CoffeeTableRepository coffeeTableRepository) {
        super();
        this.coffeeTableRepository = coffeeTableRepository;
    }

    @Override
    public CoffeeTable saveTable(CoffeeTable table) {
        validateTable(table);
        return coffeeTableRepository.save(table);
    }

    @Override
    public List<CoffeeTable> getAllTable() {
        return coffeeTableRepository.findAll();
    }

    @Override
    public CoffeeTable getTableById(long id) {
        return coffeeTableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coffee Table", "Id", id));
    }

    @Override
    public CoffeeTable updateTable(long id, CoffeeTable table) {
        validateTable(table);
        CoffeeTable existingTable = getTableById(id);
        existingTable.setArea(table.getArea());
        existingTable.setStatus(table.getStatus());
        coffeeTableRepository.save(existingTable);
        return existingTable;
    }

    @Override
    public void deleteTable(long id) {
        getTableById(id);
        coffeeTableRepository.deleteById(id);

    }

    @Override
    public List<CoffeeTable> getTablesByArea(long areaId) {
        List<CoffeeTable> coffeeTables = coffeeTableRepository.getCoffeeTablesByArea(areaId);
        if (coffeeTables.isEmpty())
            throw new ResourceNotFoundException("Coffee Table", "Area", areaId);
        return coffeeTables;
    }

    @Override
    public List<CoffeeTable> getTablesByStatus(TableStatus status) {
        List<CoffeeTable> coffeeTables = coffeeTableRepository.getCoffeeTablesByStatus(status);
        if (coffeeTables.isEmpty())
            throw new ResourceNotFoundException("Coffee Table", "Status", status);
        return coffeeTables;
    }

    @Override
    public void validateTable(CoffeeTable table) {
        if (Objects.isNull(table.getArea()))
            throw new EmptyInputException("601", "Input Fieldss are empty");
    }

}
