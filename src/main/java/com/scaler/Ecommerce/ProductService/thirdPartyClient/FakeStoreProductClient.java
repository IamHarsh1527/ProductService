package com.scaler.Ecommerce.ProductService.thirdPartyClient;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreProductClient {

    RestTemplateBuilder restTemplateBuilder;

    private String productPath ;

    private  String BaseUrl;

    private String DeleteUrl ;
    private String GetUrl ;
    private String getAllProducts;
    private String CreateUrl;

    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplate,@Value("${BaseUrl}") String BaseUrl,
                                  @Value("${productPath}") String productPath){
        this.restTemplateBuilder = restTemplate;
        this.BaseUrl =BaseUrl;
        this.productPath=productPath;
        this.DeleteUrl = BaseUrl + productPath+"/{id}";
        this.getAllProducts=BaseUrl+productPath;
        this.GetUrl = BaseUrl+productPath+"/{id}";
        this.CreateUrl = BaseUrl+productPath;
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                GetUrl,//url diya jisse data milega
                FakeStoreProductDto.class,//kis typ ka data milega
                id);//uri jo use kr k specific data milega

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        if(fakeStoreProductDto==null){
            throw new NotFoundException(" product with id: "+id+ " not available");
        }
        return fakeStoreProductDto;
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response =restTemplate.postForEntity(
                CreateUrl,
                genericProductDto,
                FakeStoreProductDto.class
        );


        FakeStoreProductDto fake = response.getBody();
        return fake;
    }


    public GenericProductDto[] getAll() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto[]> response = restTemplate.getForEntity(
                getAllProducts,
                GenericProductDto[].class);
        GenericProductDto[] prod = response.getBody();
        return prod;
    }

    public FakeStoreProductDto deleteBySpecifiedId(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> res = restTemplate
                .exchange(
                        DeleteUrl,
                        HttpMethod.DELETE,
                        null,
                        FakeStoreProductDto.class,
                        id);

        FakeStoreProductDto fakeStoreProductDto = res.getBody();
        if(fakeStoreProductDto==null){
            throw new NotFoundException("id "+id+" Not Found");
        }
        return fakeStoreProductDto;
    }
}
