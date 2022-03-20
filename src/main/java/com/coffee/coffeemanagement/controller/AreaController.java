package com.coffee.coffeemanagement.controller;

import java.util.List;

import com.coffee.coffeemanagement.model.Area;
import com.coffee.coffeemanagement.service.AreaService;

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
@RequestMapping("/api/areas")
public class AreaController {

    private AreaService areaService;

    public AreaController(AreaService areaService) {
        super();
        this.areaService = areaService;
    }

    @PostMapping
    public ResponseEntity<Area> saveArea(@RequestBody Area area) {
        return new ResponseEntity<Area>(areaService.saveArea(area), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Area> getAllAreas() {
        return areaService.getAllAreas();
    }

    @GetMapping(params = "name")
    public List<Area> getAreasByName(@RequestParam String name) {
        return areaService.getAreaByName(name);
    }

    @GetMapping("{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable("id") long id) {
        return new ResponseEntity<Area>(areaService.getAreaById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Area> updateArea(@PathVariable("id") long id, @RequestBody Area area) {
        return new ResponseEntity<Area>(areaService.updateArea(id, area), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") long id) {
        areaService.deleteArea(id);
        return new ResponseEntity<String>("Area deleted successfully.", HttpStatus.OK);
    }
}
