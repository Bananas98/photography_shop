package com.example.photography_shop.repository;

import com.example.photography_shop.entity.Role;
import com.example.photography_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<User, String> {
    Optional<User> findByRoles(String name);
    Role findByName(String name);
}
