package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.Drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    List<Drink> getDrinksByName(String name);

    @Query("SELECT d FROM Drink d, IN (d.category) AS c WHERE c.id = ?1")
    List<Drink> getDrinksByCategory(long categoryId);

    @Query("SELECT d FROM Drink d WHERE d.price BETWEEN :price1 AND :price2")
    List<Drink> getDrinksByPrice(@Param("price1") double price1, @Param("price2") double price2);
}
