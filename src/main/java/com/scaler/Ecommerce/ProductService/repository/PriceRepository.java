package com.scaler.Ecommerce.ProductService.repository;

import com.scaler.Ecommerce.ProductService.models.Price;
import com.scaler.Ecommerce.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {

}
