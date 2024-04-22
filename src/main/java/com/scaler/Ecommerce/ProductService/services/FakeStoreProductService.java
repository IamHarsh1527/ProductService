package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.thirdPartyClient.FakeStoreProductClient;
import com.scaler.Ecommerce.ProductService.thirdPartyClient.FakeStoreProductDto;
import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    private FakeStoreProductClient client;
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeStoreDtoToGeneric(client.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertFakeStoreDtoToGeneric(client.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto[] getAll() {
        return client.getAll();
    }

    @Override
    public GenericProductDto deleteBySpecifiedId(Long id) throws NotFoundException {
        return convertFakeStoreDtoToGeneric(client.deleteBySpecifiedId(id));
    }

    private GenericProductDto convertFakeStoreDtoToGeneric(FakeStoreProductDto fake) {
        GenericProductDto genericProductDto1 = new GenericProductDto();
       // genericProductDto1.setId(fake.getId());
        genericProductDto1.setPrice(fake.getPrice());
        genericProductDto1.setCategory(fake.getCategory());
        genericProductDto1.setTitle(fake.getTitle());
        genericProductDto1.setDescription(fake.getDescription());
        genericProductDto1.setImage(fake.getImage());
        return genericProductDto1;
    }
}
