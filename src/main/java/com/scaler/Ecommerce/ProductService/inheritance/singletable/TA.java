package com.scaler.Ecommerce.ProductService.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "1")
@Entity(name ="st_TA")
public class TA extends User {
    private String startTime;
    private String endTime;
}
