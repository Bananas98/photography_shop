package com.example.photography_shop.controller;

import com.example.photography_shop.entity.User;
import com.example.photography_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @DeleteMapping()
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id) {
        userService.deleteById(Long.valueOf(id));
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('USER')")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping()
    @PreAuthorize("hasAnyRole('USER')")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }
}
