package com.firstSpringApp.ecom.Service;

import com.firstSpringApp.ecom.Model.Category;
import java.util.*;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long id);
}
