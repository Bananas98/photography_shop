package com.example.photography_shop.repository;


import com.example.photography_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Some category
    List<Product> findByCategoryInOrderByCategoryAsc(List<Long> category);
    // All category
    List<Product> findAll();
    // One category
    List<Product> findAllByCategoryId(Long categoryId);
    // access to register User
    List<Product> findAllByAccessible(Boolean accessible);

}
