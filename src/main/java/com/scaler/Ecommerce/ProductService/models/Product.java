package com.scaler.Ecommerce.ProductService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base{
    private String title ;
    private Category category;
    private String desc;
    private double price;
    private String image;
}
