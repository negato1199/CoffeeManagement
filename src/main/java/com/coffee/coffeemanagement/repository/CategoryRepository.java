package com.coffee.coffeemanagement.repository;

import com.coffee.coffeemanagement.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
