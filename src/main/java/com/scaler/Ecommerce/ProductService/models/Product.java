package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends Base{

    private String title ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category")
    private Category category;

    private String descri;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Price price;

    private String image;
}

