package com.scaler.Ecommerce.ProductService.controllers;

import com.scaler.Ecommerce.ProductService.dtos.Exceptiondto;
import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;
import com.scaler.Ecommerce.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductbyId(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }


    @PostMapping("/create")
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @GetMapping()
    public GenericProductDto[] getAllProduct(){
        return productService.getAll();
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.deleteBySpecifiedId(id);
    }
}
