package com.productapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.web.entities.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
