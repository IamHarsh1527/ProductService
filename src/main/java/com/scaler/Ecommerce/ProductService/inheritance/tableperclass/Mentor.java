package com.scaler.Ecommerce.ProductService.inheritance.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_Mentor")
public class Mentor extends User {

    private double avgRating;
}
