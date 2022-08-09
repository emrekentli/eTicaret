package com.example.eticaret.repository;

import com.example.eticaret.entity.Basket;
import com.example.eticaret.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository  extends JpaRepository<Basket,Integer> {
    public Basket findBasketByUser(User user);

}
