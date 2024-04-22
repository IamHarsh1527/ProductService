package com.scaler.Ecommerce.ProductService.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value="3")
@Entity(name = "st_Mentor")
public class Mentor extends User {
    private double avgRating;
}
