package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;


public interface ProductService {
    public GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);
}
