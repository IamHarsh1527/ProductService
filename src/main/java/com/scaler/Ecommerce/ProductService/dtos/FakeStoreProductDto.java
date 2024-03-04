package com.scaler.Ecommerce.ProductService.dtos;

import com.scaler.Ecommerce.ProductService.models.Base;
import com.scaler.Ecommerce.ProductService.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto extends Base {
    private String title ;
    private String  category;
    private String description;
    private double price;
    private String image;
}
