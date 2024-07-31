package com.firstSpringApp.ecom.Controller;


import com.firstSpringApp.ecom.Model.Category;
import com.firstSpringApp.ecom.Service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
