package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Category extends Base{
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Product> products;
}
