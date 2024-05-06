package com.scaler.Ecommerce.ProductService.services;

import com.scaler.Ecommerce.ProductService.models.Category;
import com.scaler.Ecommerce.ProductService.models.Product;
import com.scaler.Ecommerce.ProductService.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public List<Product> getProductsForCategories(String name) {
        Category byName = categoryRepository.findByName(name);
        List<Product> products = new ArrayList<>();
        if (byName != null) {
            products = byName.getProducts();
        }
        return products;
    }
}
