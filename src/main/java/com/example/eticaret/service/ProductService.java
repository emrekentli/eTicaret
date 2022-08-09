package com.example.eticaret.service;

import com.example.eticaret.entity.Category;
import com.example.eticaret.entity.Product;
import com.example.eticaret.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;

    public Product addProduct(String productName, String productPrice, String productQuantity,String categoryId) {

        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(Double.parseDouble(productPrice));
        Category category = categoryService.getCategoryByCategoryId(categoryId);
        category.getProductList().add(product);
        product.setCategory(category);
        product.setProductQuantity(Integer.valueOf(productQuantity));
        return productRepository.save(product);

    }

    public Product addCategoryToProduct(String productId, String categoryId) {
    Product product = getProductById(productId);
    Category category = categoryService.getCategoryByCategoryId(categoryId);
        product.setCategory(category);
        category.getProductList().add(product);
        return productRepository.save(product);

    }
    public Product getProductById(String productId){
    return productRepository.getProductByProductId(Integer.valueOf(productId));
    }

    public List<Product> getProductsByCategoryId(String categoryId) {
        Category category = categoryService.getCategoryByCategoryId(categoryId);
        return productRepository.getProductsByCategory(category);
    }


}
