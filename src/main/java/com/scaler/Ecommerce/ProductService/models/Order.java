package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="orders")
public class Order extends Base{

    @ManyToMany
    @JoinTable(
            name = "product_orders",
            joinColumns = @JoinColumn(name = "orders_idssss"),
            inverseJoinColumns = @JoinColumn(name = "products_idssss")
    )
    private List<Product> products;


}
