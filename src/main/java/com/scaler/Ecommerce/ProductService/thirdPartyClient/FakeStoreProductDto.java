package com.scaler.Ecommerce.ProductService.thirdPartyClient;

import com.scaler.Ecommerce.ProductService.models.Base;
import com.scaler.Ecommerce.ProductService.models.Category;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {//extends Base {
    @Id
    private String id;
    private String title ;
    private String  category;
    private String description;
    private double price;
    private String image;
}
