package com.example.photography_shop.controller;

import com.example.photography_shop.entity.Product;
import com.example.photography_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @ResponseStatus(HttpStatus.OK)
    public void getAllProduct() {
        productService.getAllProducts();
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @ResponseStatus(HttpStatus.OK)
    public void getAllProductByCategory(@PathVariable String idCategory) {
        productService.findByCategoryId(Long.valueOf(idCategory));
    }


    @PostMapping()
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void addProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable String id) {
        productService.delete(id);
    }
}
