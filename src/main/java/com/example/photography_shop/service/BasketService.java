package com.example.photography_shop.service;

import com.example.photography_shop.entity.Basket;
import com.example.photography_shop.entity.Product;

import java.util.List;

public interface BasketService {

    List<Basket> getUserBasket();

//    List<Product> getProductBasket();

    Basket addToBasket(Product product);

    void deleteProductFromBasket(Long id);

    void deleteUserBasket();
}
