package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.dtos.GenericProductDto;
import com.scaler.Ecommerce.ProductService.exceptions.NotFoundException;
import com.scaler.Ecommerce.ProductService.models.Category;
import com.scaler.Ecommerce.ProductService.models.Product;
import com.scaler.Ecommerce.ProductService.repository.CategoryRepository;
import com.scaler.Ecommerce.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        Optional<Product> prod = productRepository.findById(id);
        if(prod.isEmpty()) {
            throw new NotFoundException("Product not found");
        }
        return convertToGeneric(prod.get());
    }

    private GenericProductDto convertToGeneric(Product prod) {
        GenericProductDto dto = new GenericProductDto();
        dto.setId(prod.getId());
        dto.setImage(prod.getImage());
        dto.setDescription(prod.getDescri());
        dto.setCategory(prod.getCategory());
        dto.setTitle(prod.getTitle());
        dto.setPrice(prod.getPrice());
        return dto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Product p = new Product();
        String catName = genericProductDto.getCategory().getName();
        Category category =categoryRepository.findByName(catName);
        if(category == null) {
            Category c = new Category();
            c.setName(catName);
            categoryRepository.save(c);
        }
        p.setTitle(genericProductDto.getTitle());
        p.setDescri(genericProductDto.getDescription());
        p.setCategory(categoryRepository.findByName(catName));
        p.setPrice(genericProductDto.getPrice());
        p.setImage(genericProductDto.getImage());
        //p.setId(genericProductDto.getId());
        Product prod = productRepository.save(p);
        return convertToGeneric(prod);
       // return genericProductDto;
    }

    @Override
    public GenericProductDto[] getAll() {
        List<Product> products = productRepository.findAll();
        GenericProductDto[] dtos = new GenericProductDto[products.size()];
        for(int i=0;i<products.size();i++){
            dtos[i] = convertToGeneric(products.get(i));
        }
        return dtos;
    }

    @Override
    public GenericProductDto deleteBySpecifiedId(UUID id) throws NotFoundException {
        Product p = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        GenericProductDto dto = convertToGeneric(p);
        productRepository.deleteById(id);
        return dto;
    }
}
