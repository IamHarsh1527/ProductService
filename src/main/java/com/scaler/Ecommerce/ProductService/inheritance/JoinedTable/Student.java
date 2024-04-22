package com.scaler.Ecommerce.ProductService.inheritance.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="jt_Student")
@PrimaryKeyJoinColumn(name ="user_id")
public class Student extends User {
    private double psp;
    private String batch;
}
