package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
}
