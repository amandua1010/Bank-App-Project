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
		productDao.save(product);
		return product; 
	}

	@Override
	public void deleteProduct(long id) {
		Product deleteProd = getProductById(id);
		productDao.delete(deleteProd);
	}

	@Override
	public void updateProduct(long id, Product product) {
		
		Product updateProd = getProductById(id);
		
		updateProd.setProductPrice(product.getProductPrice());
		updateProd.setProductCategory(product.getProductCategory());
		updateProd.setProductDiscount(product.getProductDiscount());
		updateProd.setProductQuantity(product.getProductQuantity());
		
		productDao.save(updateProd);
	}
	
	@Override
	public Product getProductById(long id) {
		return productDao.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " is not found"));
	}
	
}
