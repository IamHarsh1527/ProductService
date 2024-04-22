package com.scaler.Ecommerce.ProductService.inheritance.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_Mentor")
public class Mentor extends User{
    private double avgRating;
}
