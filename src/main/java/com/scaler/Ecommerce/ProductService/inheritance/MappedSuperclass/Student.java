package com.scaler.Ecommerce.ProductService.inheritance.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="Msc_Student")
public class Student extends User{
    private double psp;
    private String batch;
}
