package com.scaler.Ecommerce.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(generator = "GenerateUUID")
    @GenericGenerator(name="GenerateUUID" , strategy ="uuid2")
    @Column(name="id",columnDefinition = "binary(16)",nullable = false,updatable = false)
    private UUID Id;

//    public static void main(String[] args) {
//        UUID id = UUID.randomUUID();
//        System.out.println(id);
//    }


}
