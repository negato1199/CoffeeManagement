package com.coffee.coffeemanagement.service.impl;

import java.util.List;
import java.util.Objects;

import com.coffee.coffeemanagement.exception.DuplicatedException;
import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.Drink;
import com.coffee.coffeemanagement.repository.DrinkRepository;
import com.coffee.coffeemanagement.service.DrinkService;

import org.springframework.stereotype.Service;

@Service
public class DrinkServiceImpl implements DrinkService {

    private DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        super();
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Drink saveDrink(Drink drink) {
        validateDrink(drink);
        checkDuplicateDrink(drink);
        return drinkRepository.save(drink);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink getDrinkById(long id) {
        return drinkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drink", "id", id));
    }

    @Override
    public Drink updateDrink(long id, Drink drink) {
        validateDrink(drink);
        Drink existingDrink = getDrinkById(id);
        existingDrink.setName(drink.getName());
        existingDrink.setDescription(drink.getDescription());
        existingDrink.setImgUrl(drink.getImgUrl());
        existingDrink.getCategory().setId(existingDrink.getCategory().getId());
        existingDrink.setPrice(drink.getPrice());
        drinkRepository.save(existingDrink);
        return existingDrink;
    }

    @Override
    public void deleteDrink(long id) {
        getDrinkById(id);
        drinkRepository.deleteById(id);
    }

    @Override
    public List<Drink> getDrinksByName(String name) {
        return drinkRepository.getDrinksByName(name);
    }

    @Override
    public void validateDrink(Drink drink) {
        if (drink.getName().isBlank() || Objects.isNull(drink.getCategory())) {
            throw new EmptyInputException("601", "Input Fields are empty");
        }
    }

    @Override
    public void checkDuplicateDrink(Drink drink) {
        List<Drink> drinks = getDrinksByName(drink.getName());
        if (!drinks.isEmpty())
            throw new DuplicatedException("409", "This item is already existed");
    }

    @Override
    public List<Drink> getDrinksByCategory(long categoryId) {
        List<Drink> drinks = drinkRepository.getDrinksByCategory(categoryId);
        if (drinks.isEmpty())
            throw new ResourceNotFoundException("Drink", "Category", categoryId);
        return drinks;
    }

    @Override
    public List<Drink> getDrinksByPrice(double price1, double price2) {
        List<Drink> drinks = drinkRepository.getDrinksByPrice(price1, price2);
        if (drinks.isEmpty())
            throw new ResourceNotFoundException("Drink", "Price", "Between " + price1 + " And " + price2);
        return drinks;
    }

}
