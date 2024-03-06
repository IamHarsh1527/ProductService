package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;

import java.util.List;


public interface ProductService {
    public GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

     GenericProductDto[] getAll();

     GenericProductDto deleteBySpecifiedId(Long id);
}
