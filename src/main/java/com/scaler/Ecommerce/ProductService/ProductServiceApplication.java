package com.scaler.Ecommerce.ProductService;

import com.scaler.Ecommerce.ProductService.models.*;
import com.scaler.Ecommerce.ProductService.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	private CategoryRepository categoryRepository;

	private PriceRepository priceRepository;
	private ProductRepository productRepository;
	private OrderRepository orderRepository;


	public ProductServiceApplication(CategoryRepository categoryRepository,
									 ProductRepository productRepository,
									 PriceRepository priceRepository,
									 OrderRepository orderRepository
									 ){
		this.categoryRepository=categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
		this.orderRepository=orderRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Category category = new Category();
//		category.setName("electronics");
//		Category savedCategory = categoryRepository.save(category);
//
////		Price price = new Price("INR" , 1000);
////		Price savedPrice = priceRepository.save(price);
////
//		Product product= new Product();
//		product.setCategory(savedCategory);
//		product.setTitle("Samsung S24 ULTRA");
//		product.setDescri("best Android phone");
//		product.setImage("image");
//		product.setPrice(new Price("INR" , 2000));
//
//		productRepository.save(product);
////
//		List<Product> products = productRepository.getAll();
//		Order order = new Order(products);
////		Order savedOrder= orderRepository.save(order);


	}
}
