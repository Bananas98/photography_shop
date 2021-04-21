package com.example.photography_shop.controller;

import com.example.photography_shop.entity.Product;
import com.example.photography_shop.entity.User;
import com.example.photography_shop.service.ProductService;
import com.example.photography_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public MainController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }
//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    public String login() {
//        return "";
//    }
//
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole()")
    public void registration(@RequestBody User user) {
        userService.save(user);
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole()")
    public List<Product> getAccessProduct() {
       return productService.getByAccessProduct();
    }
}
