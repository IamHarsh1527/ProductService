package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends Base{

    private String title ;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    private String descri;

    @OneToOne(cascade = CascadeType.ALL)
    private Price price;

    private String image;
}

