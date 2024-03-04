package com.scaler.Ecommerce.ProductService.controllers;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.models.Product;
import com.scaler.Ecommerce.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/hello/{name}")
    public String SayHello(@PathVariable("name") String name){
        return "Hello "+name;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductbyId(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }
}
