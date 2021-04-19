package com.example.photography_shop.repository;

import com.example.photography_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User findByFirstNameAndAndLastName(String name);
    Optional<User> findByLogin(String login);
    Optional<User> findByLoginOptional(String login);
    Optional<Collection<User>> findAllByRoles(String role);
    Optional<User> findByActivatedCode(String activatedCode);

}
