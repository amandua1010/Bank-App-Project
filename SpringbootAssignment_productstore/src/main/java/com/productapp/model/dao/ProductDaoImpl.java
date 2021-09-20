package com.productapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.productapp.web.entities.Product;
import com.productapp.web.exceptions.ProductNotFoundException;

@Repository
@Primary
public class ProductDaoImpl implements ProductDao {

	private EntityManager entityManager;

	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> getAllProducts() {
		return entityManager.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product addProduct(Product product) {
		entityManager.persist(product);
		return product;
	}
	
	@Override
	public void deleteProduct(long id) {
		Product deleteProduct = getProductById(id);
		entityManager.remove(deleteProduct);
	}

	@Override
	public void updateProduct(long id, Product product) {
		Product updateProduct = getProductById(id);
		updateProduct.setProductPrice(product.getProductPrice() - 30);
		entityManager.merge(updateProduct);
	}
	
	@Override
	public Product getProductById(long id) {
		
		Product product = entityManager.find(Product.class, id);
		
		if(product == null) {
			throw new ProductNotFoundException("Product with id: " + id + " is not found");
		}
		
		return product;
		
	}

}
