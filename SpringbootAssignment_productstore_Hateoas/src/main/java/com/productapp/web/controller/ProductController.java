package com.productapp.web.controller;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.service.ProductService;
import com.productapp.web.entities.Product;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	

//	--------------- getAll Product Version 1 ------------------
	@GetMapping(path = "product")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
//	--------------- getAll Product Version 2 ------------------
	@GetMapping("/product/version2")
	public CollectionModel<Product> getAllProductsVersion2() {

		List<Product> productsList = productService.getAllProducts();

		productsList.forEach(product -> {
			Link link = linkTo(methodOn(ProductController.class).getAllProductsVersion2()).withSelfRel();
			product.add(link);
		});

		return CollectionModel.of(productsList);
		
	}
	

//	--------------- get Single Product Version 1 ------------------
	@GetMapping(path = "product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "id") long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductById(id));
	}
	
//	--------------- get Single Product Version 2 with HATEOAS ------------------
	@GetMapping(path = "product/version2/{id}")
	public EntityModel<Product> getProductByIdVersion2(@PathVariable(name = "id") long id) {
		
		Link link = linkTo(methodOn(ProductController.class).getProductByIdVersion2(id)).withSelfRel();
		Product product = productService.getProductById(id);
		product.add(link);
		
		return EntityModel.of(product);
		
	}
	

//	--------------- Add new Product ------------------	
	@PostMapping(path = "product")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(product));
	}

//	--------------- Delete Product ------------------
	@DeleteMapping(path = "product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") long id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product is deleted with id: " + id);
	}

//	--------------- Update Product ------------------
//	@PutMapping(path = "product/{id}")
//	public ResponseEntity<Product> updateProduct(@PathVariable(name = "id") long id, @RequestBody Product product) {
//		return ResponseEntity.ok(productService.updateProduct(id, product));
//	}

}
