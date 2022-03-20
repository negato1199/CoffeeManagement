package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.Drink;

public interface DrinkService {
    Drink saveDrink(Drink drink);

    List<Drink> getAllDrinks();

    Drink getDrinkById(long id);

    Drink updateDrink(long id, Drink drink);

    void deleteDrink(long id);

    List<Drink> getDrinksByName(String name);

    void validateDrink(Drink drink);

    void checkDuplicateDrink(Drink drink);

    List<Drink> getDrinksByCategory(long categoryId);

    List<Drink> getDrinksByPrice(double price1, double price2);
}
