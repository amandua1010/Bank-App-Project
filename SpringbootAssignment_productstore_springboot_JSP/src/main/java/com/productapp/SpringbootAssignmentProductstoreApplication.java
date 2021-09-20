package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.productapp.model.service.ProductService;
import com.productapp.web.entities.Product;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootAssignmentProductstoreApplication implements CommandLineRunner {
	
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAssignmentProductstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product product1 = new Product("Laptop", 68000.0, 1000.0, "Electronics", 3L);
		Product product2 = new Product("Notebooks", 1000.0, 100.0, "Stationery", 1L);
		Product product3 = new Product("Vaccum Cleaner", 8900.0, 320.0, "Gadgets", 3L);
		
		productService.addProduct(product1);
		productService.addProduct(product2);
		productService.addProduct(product3);
		
	}

}
