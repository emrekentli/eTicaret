package com.example.eticaret.service;

import com.example.eticaret.entity.Category;
import com.example.eticaret.entity.Product;
import com.example.eticaret.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category addCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return categoryRepository.save(category);
    }

    public Category getCategoryByCategoryId(String categoryId) {
        return categoryRepository.getCategoryByCategoryId(Integer.valueOf(categoryId));
    }


}
