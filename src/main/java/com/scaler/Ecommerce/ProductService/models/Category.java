package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Category extends Base{
    private String name;
}
