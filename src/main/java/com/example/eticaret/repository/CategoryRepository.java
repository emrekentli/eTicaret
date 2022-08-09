package com.example.eticaret.repository;

import com.example.eticaret.entity.Category;
import com.example.eticaret.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    public Category getCategoryByCategoryId(Integer categoryId);


}
