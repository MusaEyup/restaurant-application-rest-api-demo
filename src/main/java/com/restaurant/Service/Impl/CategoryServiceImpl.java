package com.restaurant.Service.Impl;

import com.restaurant.Context.CategoryContext;
import com.restaurant.Entity.Category;
import com.restaurant.Repository.CategoryRepository;
import com.restaurant.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findCategoryById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepo.findCategoryByName(name);
    }

    @Override
    @Transactional
    public Long addNewCategory(Category category) {
        Long id = (categoryRepo.findMaxId() != null) ? categoryRepo.findMaxId() + 1 : 1 ;
        category.setId(id);
        categoryRepo.save(category);
        return id;
    }

    @Override
    @Transactional
    public Long deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
        return id;
    }

    @Override
    public List<CategoryContext> getAllCategoryContext() {
        List<CategoryContext> categoryContexts = new ArrayList<>();

        categoryRepo.findAll().forEach(category -> {
            categoryContexts.add(new CategoryContext(category.getId(), category.getName()));
        });
        return categoryContexts;
    }

}
