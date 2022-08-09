package com.example.eticaret.controller;

import com.example.eticaret.entity.Basket;
import com.example.eticaret.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    BasketService basketService;
    @GetMapping("/{userId}")
    public Basket getBasketByUserId(@PathVariable(name="userId") String userId){
        return basketService.getBasketByUserId(userId);
    }
    @GetMapping("addToBasket/{userId}/{productId}/{numberOfProduct}")
    public Basket addProductToBasket(@PathVariable(name="userId") String userId,
                                     @PathVariable(name="productId") String productId,
                                     @PathVariable(name="numberOfProduct") String numberOfProduct){
        return basketService.addProductToBasket(userId,productId,numberOfProduct);
    }

}
