package com.example.photography_shop.service;

import com.example.photography_shop.entity.User;
import com.example.photography_shop.entity.dto.RemindPassword;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User save(User user);

    List<User> getAll();

    User update(User user);

    User getCurrentUser();

    User getById(Long id);

    void deleteById(Long id);

    void remindPassword(RemindPassword remindPassword);

    void restartPassword(String activatedCode, RemindPassword remindPassword);

    User findOne(String login);

//    Collection<User> findByRole(String role);

}
