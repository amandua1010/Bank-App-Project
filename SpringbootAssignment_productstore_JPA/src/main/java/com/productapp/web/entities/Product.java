package com.productapp.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignment_product_table_2")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private Double productPrice;
	private Double productDiscount;
	private String productCategory;
	private Long productQuantity;

	public Product() {
	}

	public Product(String productName, Double productPrice, Double productDiscount, String productCategory, Long productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	public Product(Long productId, String productName, Double productPrice, Double productDiscount, String productCategory, Long productQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", productDiscount=");
		builder.append(productDiscount);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append(", productQuantity=");
		builder.append(productQuantity);
		builder.append("]");
		return builder.toString();
	}

}
