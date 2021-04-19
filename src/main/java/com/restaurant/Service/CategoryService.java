package com.restaurant.Service;

import com.restaurant.Entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    Long addNewCategory(Category category);
    Long deleteCategoryById(Long id);
}
