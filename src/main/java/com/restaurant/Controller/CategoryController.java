package com.restaurant.Controller;

import com.restaurant.Context.CategoryContext;
import com.restaurant.Entity.Category;
import com.restaurant.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/getall")
    public List<CategoryContext> getAllCategoryContext(){
        return categoryService.getAllCategoryContext();
    }

    @GetMapping("/name/{name}")
    public Category getCategoryByName(@PathVariable("name") String name){
        return categoryService.getCategoryByName(name);
    }
    @PostMapping("/")
    public Long addNewCategory(@RequestBody Category category) {

        return categoryService.addNewCategory(category);
    }

    @DeleteMapping("/{id}")
    public Long deleteCategoryById(@PathVariable("id") Long id) {

        return  categoryService.deleteCategoryById(id);
    }
}
