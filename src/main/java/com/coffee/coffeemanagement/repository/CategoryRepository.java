package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> getCategoriesByName(String name);
}
