package com.scaler.Ecommerce.ProductService.controllers;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;
import com.scaler.Ecommerce.ProductService.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;


    @Test
    public void testGetProductByIdReturnsCorrectResponse() throws NotFoundException {
//        GenericProductDto genericProductDto = new GenericProductDto();
//        genericProductDto.setId(UUID.fromString("0b11e1f5-e7e5-4971-9c55-b9365c733e62"));
//        genericProductDto.setTitle("lenovo");
//
//        when(productService.getProductById(any())
//                .thenReturn(genericProductDto);
//
//        GenericProductDto res = productController.getProductbyId(UUID.fromString("0b11e1f5-e7e5-4971-9c55-b9365c733e62"));
//        Assertions.assertEquals(res.getTitle(),genericProductDto.getTitle());
//        Assertions.assertEquals(res.getId(),genericProductDto.getId());
        when(productService.getProductById(any()))
                .thenReturn(null);
        GenericProductDto res  = productController.getProductbyId(UUID.fromString("0b11e1f5-e7e5-4971-9c55-b9365c733e62"));
        Assertions.assertNull(res);
    }

}
