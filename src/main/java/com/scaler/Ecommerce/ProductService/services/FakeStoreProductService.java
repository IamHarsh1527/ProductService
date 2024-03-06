package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.dtos.FakeStoreProductDto;
import com.scaler.Ecommerce.ProductService.dtos.GenericList;
import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    private  String DeleteUrl ="https://fakestoreapi.com/products/{id}";
    private String GetUrl = "https://fakestoreapi.com/products/{id}";
    private String getproducts ="https://fakestoreapi.com/products";
    private String CreateUrl = "https://fakestoreapi.com/products";
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
       // RestTemplate rr = new RestTemplate();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                GetUrl,
                FakeStoreProductDto.class,
                id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        if(fakeStoreProductDto==null){
            throw new NotFoundException(" product with id: "+id+ " not available");
        }
        GenericProductDto genericProductDto = convertFakeStoreDtoToGeneric(fakeStoreProductDto);
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
        GenericProductDto genericProductDto1 = convertFakeStoreDtoToGeneric(fake);
        return genericProductDto1;
    }

    @Override
    public GenericProductDto[] getAll() {
        RestTemplate restTemplate = restTemplateBuilder.build();
//        GenericList res =restTemplate.getForObject(getproducts, GenericList.class);
//        List<FakeStoreProductDto> l = res.getProducts();
//        for(FakeStoreProductDto dto : l){
//            GenericProductDto genericProductDto = convertFakeStoreDtoToGeneric(dto);
//        }
//        return null;
        ResponseEntity<GenericProductDto[]> response = restTemplate.getForEntity(
                getproducts,
                GenericProductDto[].class);
        GenericProductDto[] prod = response.getBody();
        return prod;
    }

    @Override
    public GenericProductDto deleteBySpecifiedId(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> res = restTemplate
                .exchange(
                        DeleteUrl,
                        HttpMethod.DELETE,
                        null,
                        FakeStoreProductDto.class,
                        id);

        FakeStoreProductDto fakeStoreProductDto = res.getBody();
        GenericProductDto genericProductDto = convertFakeStoreDtoToGeneric(fakeStoreProductDto);
        return genericProductDto;
    }

    private GenericProductDto convertFakeStoreDtoToGeneric(FakeStoreProductDto fake) {
        GenericProductDto genericProductDto1 = new GenericProductDto();
        genericProductDto1.setId(fake.getId());
        genericProductDto1.setPrice(fake.getPrice());
        genericProductDto1.setCategory(fake.getCategory());
        genericProductDto1.setTitle(fake.getTitle());
        genericProductDto1.setDescription(fake.getDescription());
        genericProductDto1.setImage(fake.getImage());
        return genericProductDto1;
    }
}
