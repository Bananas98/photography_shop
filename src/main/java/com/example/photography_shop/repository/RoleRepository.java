package com.example.photography_shop.repository;

import com.example.photography_shop.entity.Role;
import com.example.photography_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<User, String> {
    Role findByLogin(String login);
}
