package com.firstSpringApp.ecom.Controller;


import com.firstSpringApp.ecom.Model.Category;
import com.firstSpringApp.ecom.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/api/public/categories")
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCatogory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category Added Successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        return categoryService.deleteCategory(categoryId);
    }

}
