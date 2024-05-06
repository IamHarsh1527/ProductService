package com.scaler.Ecommerce.ProductService.dtos;

import com.scaler.Ecommerce.ProductService.models.Base;
import com.scaler.Ecommerce.ProductService.models.Category;
import com.scaler.Ecommerce.ProductService.models.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto extends Base {
    private String title ;
    private Category category;
    private String description;
    private Price price;
    private String image;
}
