package com.scaler.Ecommerce.ProductService.inheritance.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name ="user_id")
@Entity(name ="jt_TA")
public class TA extends User {
    private String startTime;
    private String endTime;
}
