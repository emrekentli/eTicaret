package com.example.eticaret.repository;
import com.example.eticaret.entity.Category;
import com.example.eticaret.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product getProductByProductId(Integer productId);

    List<Product> getProductsByCategory(Category category);
}
