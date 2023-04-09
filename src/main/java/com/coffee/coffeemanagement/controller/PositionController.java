package com.coffee.coffeemanagement.controller;

import java.util.List;

import com.coffee.coffeemanagement.model.Position;
import com.coffee.coffeemanagement.service.PositionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/positions")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        super();
        this.positionService = positionService;
    }

    @PostMapping
    public ResponseEntity<Position> savePosition(@RequestBody Position position) {
        return new ResponseEntity<Position>(positionService.savePosition(position), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping(params = "name")
    public List<Position> getPositionsByName(@RequestParam String name) {
        return positionService.getPositionsByName(name);
    }

    @GetMapping("{id}")
    public ResponseEntity<Position> getStaffById(@PathVariable("id") long id) {
        return new ResponseEntity<Position>(positionService.getPositionById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Position> updateStaff(@PathVariable("id") long id, @RequestBody Position position) {
        return new ResponseEntity<Position>(positionService.updatePosition(id, position), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") long id) {
        positionService.deletePosition(id);
        return new ResponseEntity<String>("Position deleted successfully.", HttpStatus.OK);
    }
}
