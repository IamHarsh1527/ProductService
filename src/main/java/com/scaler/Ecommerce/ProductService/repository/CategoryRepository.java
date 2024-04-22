package com.scaler.Ecommerce.ProductService.repository;

import com.scaler.Ecommerce.ProductService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
