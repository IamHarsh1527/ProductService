package com.scaler.Ecommerce.ProductService.inheritance.JoinedTable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name ="user_id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String  email;
}
