package com.productapp.model.dao;

import java.util.List;

import com.productapp.web.entities.Product;


public interface ProductDao {
	
	public List<Product> getAllProducts();
	
	public Product addProduct(Product product);

	public void deleteProduct(long product);

	public void updateProduct(long id, Product product);
	
	public Product getProductById(long id);

}
