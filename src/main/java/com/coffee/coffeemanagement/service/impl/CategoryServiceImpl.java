package com.coffee.coffeemanagement.service.impl;

import java.util.List;

import com.coffee.coffeemanagement.exception.DuplicatedException;
import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.Category;
import com.coffee.coffeemanagement.repository.CategoryRepository;
import com.coffee.coffeemanagement.service.CategoryService;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        validateCategory(category);
        checkDuplicateCategory(category);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
    }

    @Override
    public Category updateCategory(long id, Category category) {
        validateCategory(category);
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void deleteCategory(long id) {
        getCategoryById(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategoryByName(String name) {
        return categoryRepository.getCategoriesByName(name);
    }

    @Override
    public void validateCategory(Category category) {
        if (category.getName().isBlank()) {
            throw new EmptyInputException("601", "Input Fields are empty");
        }
    }

    @Override
    public void checkDuplicateCategory(Category category) {
        List<Category> categories = getCategoryByName(category.getName());
        if (!categories.isEmpty())
            throw new DuplicatedException("409", "This item is already existed");
    }
}
