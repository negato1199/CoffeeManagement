package com.coffee.coffeemanagement.controller;

import java.util.List;

import com.coffee.coffeemanagement.model.Drink;
import com.coffee.coffeemanagement.service.DrinkService;

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
@RequestMapping("/api/drinks")
public class DrinkController {

    private DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        super();
        this.drinkService = drinkService;
    }

    @PostMapping
    public ResponseEntity<Long> saveDrink(@RequestBody Drink drink) {
        return new ResponseEntity<Long>(drinkService.saveDrink(drink).getId(), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @GetMapping(params = "name")
    public List<Drink> getDrinksByName(@RequestParam String name) {
        return drinkService.getDrinksByName(name);
    }

    @GetMapping(params = { "price1", "price2" })
    public List<Drink> getDrinksByPrice(@RequestParam double price1, @RequestParam double price2) {
        return drinkService.getDrinksByPrice(price1, price2);
    }

    @GetMapping(params = "categoryId")
    public List<Drink> getDrinksByCategory(@RequestParam long categoryId) {
        return drinkService.getDrinksByCategory(categoryId);
    }

    @GetMapping("{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable("id") long id) {
        return new ResponseEntity<Drink>(drinkService.getDrinkById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable("id") long id, @RequestBody Drink drink) {
        return new ResponseEntity<Drink>(drinkService.updateDrink(id, drink), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDrink(@PathVariable("id") long id) {
        drinkService.deleteDrink(id);
        return new ResponseEntity<String>("Drink deleted successfully.", HttpStatus.OK);
    }
}
