package com.firstSpringApp.ecom.Controller;


import com.firstSpringApp.ecom.Model.Category;
import com.firstSpringApp.ecom.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api")
//We can add the common part of the ENDPOINT in the API here so that it can embed in all the API's across the class
public class CategoryController {


    // instead of assigning it using the constructor we can use autowired to instantiate with the categoryService obj.
    @Autowired
    private CategoryService categoryService;



    // @GetMapping("/public/categories")
    // Instead of GetMapping we can use RequestMapping and pass the value and method to it specity the type and path of the ENDPOINT
    @RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCatogory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category Created Successfully",HttpStatus.CREATED);
    }

    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long id){
        try{
            Category savedCategory = categoryService.updateCategory(category,id);
            return new ResponseEntity<>("Updated Category with Id " + id,HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        // adding ResponseEntity to success and error messages and wrapping them under the ResponseEntity
        try{
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

}
