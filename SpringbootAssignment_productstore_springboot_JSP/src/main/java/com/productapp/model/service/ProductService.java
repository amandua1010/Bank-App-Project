package com.productapp.model.service;

import java.util.List;

import com.productapp.web.entities.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();

	public Product addProduct(Product product);

	public Product deleteProduct(long product);

	public Product updateProduct(long id, Product product);

	public Product getProductById(long id);

}
