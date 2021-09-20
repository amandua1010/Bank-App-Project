package com.productapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.model.dao.ProductDao;
import com.productapp.web.entities.Product;
import com.productapp.web.exceptions.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public void deleteProduct(long id) {
		Product deleteProduct = getProductById(id);
		productDao.delete(deleteProduct);
	}

	@Override
	public void updateProduct(long id, Product product) {
		Product updateProduct = getProductById(id);
		updateProduct.setProductPrice(product.getProductPrice());
		productDao.save(updateProduct);
	}
	
	@Override
	public Product getProductById(long id) {
		return productDao.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " is not found"));
	}
	
}
