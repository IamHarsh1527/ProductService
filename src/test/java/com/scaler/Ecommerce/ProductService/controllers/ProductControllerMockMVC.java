package com.scaler.Ecommerce.ProductService.controllers;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.repository.ProductRepository;
import com.scaler.Ecommerce.ProductService.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerMockMVC {

    @MockBean
    private ProductService productService;
    @Autowired
    private ProductController productController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProductById() throws Exception {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle("iphone");

        when(productController.getProductbyId(UUID.fromString("0b11e1f5-e7e5-4971-9c55-b9365c733e62")))
                .thenReturn(genericProductDto);
        mockMvc.perform(get("/products/0b11e1f5-e7e5-4971-9c55-b9365c733e62"))
                .andExpect(status().is(200));

    }

}
