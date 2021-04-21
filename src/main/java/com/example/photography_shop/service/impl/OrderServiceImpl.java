package com.example.photography_shop.service.impl;

import com.example.photography_shop.entity.Basket;
import com.example.photography_shop.entity.Order;
import com.example.photography_shop.entity.User;
import com.example.photography_shop.repository.OrderRepository;
import com.example.photography_shop.service.BasketService;
import com.example.photography_shop.service.OrderService;
import com.example.photography_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BasketService basketService;
    private final UserService userService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, BasketService basketService, UserService userService) {
        this.orderRepository = orderRepository;
        this.basketService = basketService;
        this.userService = userService;
    }

    @Override
    public void addProductsFromBasketToOrder() {
        List<Basket> userBasket = basketService.getUserBasket();
        Order orders1 = new Order();
        User user = new User();
        orders1.setOrderNumber(UUID.randomUUID().toString());
        for (Basket basket : userBasket) {

            orders1.setProduct(basket.getProduct());
            orders1.setUser(user);
            orderRepository.save(orders1);
        }
        basketService.deleteUserBasket();
        System.out.println("Items had been added to order. Your basket is empty.");
    }

    @Override
    public List<OrderRepository.GroupedOrders> getOrders() {
        //return orderRepository.getOrdersForCurrentUser(userService.getCurrentUser().getId());
        return null;
    }

    @Override
    public void getOrdersDetails(String orderNumber) {
        orderRepository.getOrdersByOrderNumber(orderNumber);
    }

}
