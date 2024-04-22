package com.scaler.Ecommerce.ProductService.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "2")
@Entity(name ="st_Student")
public class Student extends User {
    private double psp;
    private String batch;
}
