package com.example.photography_shop.service;

import com.example.photography_shop.repository.OrderRepository;

import java.util.List;

public interface OrderService {
    void addProductsFromBasketToOrder();

    List<OrderRepository.GroupedOrders> getOrders();

    void getOrdersDetails(String orderNumber);
}
