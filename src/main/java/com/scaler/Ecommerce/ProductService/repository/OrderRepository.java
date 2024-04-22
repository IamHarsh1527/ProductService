package com.scaler.Ecommerce.ProductService.repository;

import com.scaler.Ecommerce.ProductService.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
