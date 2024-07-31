package com.firstSpringApp.ecom.Service;
import com.firstSpringApp.ecom.Model.Category;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CategoryServiceImpl implements CategoryService{

    List<Category> categoryList = new ArrayList<>();
    public List<Category> getAllCategories(){
        return categoryList;
    }

    @Override
    public void createCategory(Category category) {
        categoryList.add(category);
    }

}
