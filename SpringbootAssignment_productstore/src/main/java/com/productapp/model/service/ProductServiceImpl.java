package com.productapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.model.dao.ProductDao;
import com.productapp.web.entities.Product;

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
		return productDao.getAllProducts();
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public void deleteProduct(long product) {
		productDao.deleteProduct(product);
	}

	@Override
	public void updateProduct(long id, Product product) {
		productDao.updateProduct(id, product);
	}
	
	@Override
	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}
	
}
