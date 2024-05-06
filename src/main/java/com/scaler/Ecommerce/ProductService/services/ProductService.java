package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;


public interface ProductService {
    public GenericProductDto getProductById(UUID id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

     GenericProductDto[] getAll();

     GenericProductDto deleteBySpecifiedId(UUID id) throws NotFoundException;
}
