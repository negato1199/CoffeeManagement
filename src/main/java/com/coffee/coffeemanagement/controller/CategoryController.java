package com.coffee.coffeemanagement.controller;

import com.coffee.coffeemanagement.model.Category;
import com.coffee.coffeemanagement.service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        System.out.println(category);
        return new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }
}
