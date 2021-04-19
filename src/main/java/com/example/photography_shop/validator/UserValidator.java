package com.example.photography_shop.validator;

import com.example.photography_shop.entity.User;
import com.example.photography_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private Environment environment;
//
//    public void validate(User user) throws UserCreationException{
//        if (user.getFirstName().length() < 5 || userDTO.getUsername().length() > 256) {
//            throw new UserCreationException(environment.getProperty("size.userForm.username"));
//        }
//        if (userService.findByUsername(userDTO.getUsername()) != null) {
//            throw new UserCreationException(environment.getProperty("duplicate.userForm.username"));
//        }
//        if (userDTO.getPassword().length() < 5) {
//            throw new UserCreationException(environment.getProperty("size.userForm.password"));
//        }
//    }
}
