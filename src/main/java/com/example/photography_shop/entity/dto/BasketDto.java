package com.example.photography_shop.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BasketDto {
    private List<ProductDto> productsDto;
    private Integer totalAmount;
}
