package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.Category;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(long id);

    Category updateCategory(long id, Category category);

    void deleteCategory(long id);

    List<Category> getCategoryByName(String name);

    void validateCategory(Category category);

    void checkDuplicateCategory(Category category);
}
