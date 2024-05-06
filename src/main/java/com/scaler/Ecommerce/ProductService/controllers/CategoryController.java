package com.scaler.Ecommerce.ProductService.controllers;

import com.scaler.Ecommerce.ProductService.models.Category;
import com.scaler.Ecommerce.ProductService.models.Product;
import com.scaler.Ecommerce.ProductService.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{name}")
    public List<Product> getProductByCategory(@PathVariable("name") String name) {
        return categoryService.getProductsForCategories(name);
    }


}
