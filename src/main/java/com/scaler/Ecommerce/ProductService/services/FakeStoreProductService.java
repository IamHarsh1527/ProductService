package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.dtos.FakeStoreProductDto;
import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    private String GetUrl = "https://fakestoreapi.com/products/{id}";
    private String CreateUrl = "https://fakestoreapi.com/products";
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate rr = new RestTemplate();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                GetUrl,
                FakeStoreProductDto.class,
                id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response =restTemplate.postForEntity(
                CreateUrl,
                genericProductDto,
                FakeStoreProductDto.class
        );
        FakeStoreProductDto fake = response.getBody();
        GenericProductDto genericProductDto1 = new GenericProductDto();
        genericProductDto1.setPrice(fake.getPrice());
        genericProductDto1.setCategory(fake.getCategory());
        genericProductDto1.setTitle(fake.getTitle());
        genericProductDto1.setDescription(fake.getDescription());
        genericProductDto1.setImage(fake.getImage());
        return genericProductDto;
    }
}
