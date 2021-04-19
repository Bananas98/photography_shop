package com.example.photography_shop.controller;

import com.example.photography_shop.entity.Basket;
import com.example.photography_shop.entity.Product;
import com.example.photography_shop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
public class BasketController {

    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }


    @GetMapping
    public List<Basket> getUserBasket() {
        return basketService.getUserBasket();
    }

    @PostMapping
    public Basket addProductToBasket(@RequestBody Product product) {
        return basketService.addToBasket(product);
    }


    @DeleteMapping("/{id}")
    public void deleteProductFromBasketById(@PathVariable Long id) {
        basketService.deleteProductFromBasket(id);
    }


    @DeleteMapping
    public void deleteUserBasket() {
        basketService.deleteUserBasket();
    }
}
