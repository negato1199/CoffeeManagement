package com.coffee.coffeemanagement.controller;

import java.util.List;

import com.coffee.coffeemanagement.model.CoffeeTable;
import com.coffee.coffeemanagement.model.enums.TableStatus;
import com.coffee.coffeemanagement.service.CoffeeTableService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tables")
public class CoffeeTableController {

    private CoffeeTableService coffeeTableService;

    public CoffeeTableController(CoffeeTableService coffeeTableService) {
        super();
        this.coffeeTableService = coffeeTableService;
    }

    @PostMapping
    public ResponseEntity<CoffeeTable> saveCoffeeTable(@RequestBody CoffeeTable coffeeTable) {
        return new ResponseEntity<CoffeeTable>(coffeeTableService.saveTable(coffeeTable), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CoffeeTable> getAllCoffeeTables() {
        return coffeeTableService.getAllTable();
    }

    @GetMapping(params = "area")
    public List<CoffeeTable> getCoffeeTablesByArea(@RequestParam long area) {
        return coffeeTableService.getTablesByArea(area);
    }

    @GetMapping(params = "status")
    public List<CoffeeTable> getCoffeeTablesByStatus(@RequestParam TableStatus status) {
        return coffeeTableService.getTablesByStatus(status);
    }

    @GetMapping("{id}")
    public ResponseEntity<CoffeeTable> getCoffeeTableById(@PathVariable("id") long id) {
        return new ResponseEntity<CoffeeTable>(coffeeTableService.getTableById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CoffeeTable> updateCoffeeTable(@PathVariable("id") long id,
            @RequestBody CoffeeTable coffeeTable) {
        return new ResponseEntity<CoffeeTable>(coffeeTableService.updateTable(id, coffeeTable), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCoffeeTable(@PathVariable("id") long id) {
        coffeeTableService.deleteTable(id);
        return new ResponseEntity<String>("Staff deleted successfully.", HttpStatus.OK);
    }
}
