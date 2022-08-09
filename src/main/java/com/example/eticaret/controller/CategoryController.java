package com.example.eticaret.controller;

import com.example.eticaret.entity.Category;
import com.example.eticaret.entity.Product;
import com.example.eticaret.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/add/{categoryName}")
    public Category addCategory(@PathVariable (name="categoryName") String categoryName){
        return categoryService.addCategory(categoryName);

    }
    @GetMapping("/{categoryId}")
    public Category getCategoryByCategoryId(@PathVariable (name="categoryId") String categoryId){
        return categoryService.getCategoryByCategoryId(categoryId);
    }


}
