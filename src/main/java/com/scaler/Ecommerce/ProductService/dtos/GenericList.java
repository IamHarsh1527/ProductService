package com.scaler.Ecommerce.ProductService.dtos;

import com.scaler.Ecommerce.ProductService.thirdPartyClient.FakeStoreProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenericList {
    private List<FakeStoreProductDto> products;

    public GenericList(){
        products = new ArrayList<>();
    }
}
