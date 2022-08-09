package com.example.eticaret.service;

import com.example.eticaret.entity.Basket;
import com.example.eticaret.entity.Product;
import com.example.eticaret.entity.User;
import com.example.eticaret.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    public Basket createBasket(User user) {
        Basket basket = new Basket();
        basket.setUser(user);
        basket.setBasketAmount(0);
        return basketRepository.save(basket);
    }

    public Basket getBasketByUserId(String userId) {
        User user = userService.getUserByUserId(userId);
        return basketRepository.findBasketByUser(user);
    }


    public Basket addProductToBasket(String userId, String productId, String numberOfProduct) {
        Basket basket = getBasketByUserId(userId);
        Product product = productService.getProductById(productId);

        double total = 0;
        total=Integer.valueOf(numberOfProduct) * product.getProductPrice();
        basket.setBasketAmount(total+basket.getBasketAmount());

         basket.setBasketProductList(addProductsToList(productId,numberOfProduct));


        return basketRepository.save(basket);

    }

    public List<Product> addProductsToList(String productId,String numberOfProduct){

        Product product= productService.getProductById(productId);
        List<Product> productList = new ArrayList<Product>();
        for (int i = 0; i < Integer.valueOf(numberOfProduct); i++) {
        productList.add(product);
        }
        return productList;
    }


}
