package com.scaler.Ecommerce.ProductService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class Exceptiondto {

    private HttpStatus httpStatus;
    private String messsage;

}
