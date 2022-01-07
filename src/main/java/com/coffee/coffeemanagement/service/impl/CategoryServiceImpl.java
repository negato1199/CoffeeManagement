package com.coffee.coffeemanagement.service.impl;

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
        return categoryRepository.save(category);
    }

}
