package com.scaler.Ecommerce.ProductService.repository;

import com.scaler.Ecommerce.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "select * from Product ",nativeQuery = true)
    List<Product> getAll();
}
