package com.firstSpringApp.ecom.Service;
import com.firstSpringApp.ecom.Model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class CategoryServiceImpl implements CategoryService{

    List<Category> categoryList = new ArrayList<>();

    // For generating the categoryId automatically wthout user intervention
    private Long nextId = 1L;
    public List<Category> getAllCategories(){
        return categoryList;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categoryList.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryList.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not found"));
        categoryList.remove(category);
        return "Category with CategoryId "+ categoryId + " deleted Successfully";
    }

}
