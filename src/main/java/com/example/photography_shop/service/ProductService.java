package com.example.photography_shop.service;

import com.example.photography_shop.entity.Product;
import java.util.List;
import java.util.Set;

public interface ProductService {
    Product save(Product product);
    Product update(Product product);
    void delete(String productId);
    Product getByIdProduct(Long id);
    List<Product> getByAccessProduct();
    List<Product> getByPrivateAccessProduct();
    public Iterable<Product> getAllProducts();

    public Iterable<Product> findByCategoryId(Long categoryId);
    public Iterable<Product> findByCategories(List<Integer> categories);
}
