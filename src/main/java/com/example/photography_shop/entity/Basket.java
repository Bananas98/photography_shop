package com.example.photography_shop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Basket {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Product product;


    @ManyToOne
    private User user;


}
