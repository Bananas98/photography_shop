package com.example.photography_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private Double price;
    private String linkToPhotos;
    private Integer year;
    private String descriptionProduct;
    private Boolean accessible;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

}