package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends Base{

    private String title ;

    @ManyToOne
    private Category category;

    private String descri;

    private double price;

    private String image;
}

