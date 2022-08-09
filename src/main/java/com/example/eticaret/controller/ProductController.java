package com.example.eticaret.controller;

import com.example.eticaret.entity.Product;
import com.example.eticaret.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/add/{productName}/{productPrice}/{productQuantity}/{categoryId}")
    public Product addProduct(@PathVariable(name = "productName") String productName,
                              @PathVariable (name = "productPrice") String productPrice,
                              @PathVariable (name = "productQuantity") String productQuantity,
                              @PathVariable (name = "categoryId") String categoryId){

        return productService.addProduct(productName,productPrice,productQuantity,categoryId);

    }
    @GetMapping("/addCategory/{productId}/{categoryId}")
    public Product addCategoryToProduct(@PathVariable(name = "productId") String productId,
                                     @PathVariable (name = "categoryId") String categoryId){
        return productService.addCategoryToProduct(productId,categoryId);

    }
    @GetMapping("/{categoryId}")
    public List<Product> getAllByCategoryId(@PathVariable (name="categoryId") String categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }
}
