package com.scaler.Ecommerce.ProductService.exceptions;

import com.scaler.Ecommerce.ProductService.dtos.Exceptiondto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Exceptiondto> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(new Exceptiondto(HttpStatus.NOT_FOUND,notFoundException.getMessage()) ,
                HttpStatus.NOT_FOUND);
    }

}
