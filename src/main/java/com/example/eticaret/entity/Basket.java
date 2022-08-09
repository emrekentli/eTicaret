package com.example.eticaret.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Basket {
    @Id
    @Column(name = "user_id")
    private Integer basketId;
    private double basketAmount;
    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "basket")
    @JsonManagedReference
    private List<Product> basketProductList;

    public Basket(Integer basketId, double basketAmount, User user, List<Product> basketProductList) {
        this.basketId = basketId;
        this.basketAmount = basketAmount;
        this.user = user;
        this.basketProductList = basketProductList;
    }

    public Basket() {
    }

    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {
        this.basketId = basketId;
    }

    public double getBasketAmount() {
        return basketAmount;
    }

    public void setBasketAmount(double basketAmount) {
        this.basketAmount = basketAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getBasketProductList() {
        return basketProductList;
    }

    public void setBasketProductList(List<Product> basketProductList) {
        this.basketProductList = basketProductList;
    }
}
