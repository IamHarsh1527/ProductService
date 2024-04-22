package com.scaler.Ecommerce.ProductService.inheritance.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="Msc_TA")
public class TA extends User{
    private String startTime;
    private String endTime;
}
