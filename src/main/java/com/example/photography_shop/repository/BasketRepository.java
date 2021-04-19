package com.example.photography_shop.repository;

import com.example.photography_shop.entity.Basket;
import com.example.photography_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, String> {

    Optional<Basket> findByProductIdAndUserId(Long productId, Long userId);

    void deleteByUserLogin(String Login);

    List<Basket> getBasketByUserName(String name);

    void deleteByUserLoginAndProductId(String login, Long id);


}
