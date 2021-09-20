package com.productapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.model.service.ProductService;
import com.productapp.web.entities.Product;

@Controller
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
//	--------------- getAll Product ------------------
	@GetMapping(value = "allProducts")
	public String showAllProducts(ModelMap map) {
		
		map.addAttribute("products", productService.getAllProducts());
		return "allProducts";
		
	}
	
	
//	--------------- Add new Product ------------------
	// GET method
	@GetMapping(value = "addProduct")
	public String addProductGet(ModelMap map) {
		
		map.addAttribute("product", new Product());
		return "addProduct";
		
	}
	
	// POST method
	@PostMapping(value = "addProduct")
	public String addProductPost(@ModelAttribute(name = "product") Product product) {
		
		Long prodId = (product.getProductId());			// to differentiate the update and the add method of products
		
		if(prodId == null) {
			productService.addProduct(product);
		}
		
		else {
			productService.updateProduct(prodId, product);
		}
		
		return "redirect:allProducts";
	
	}
	
	
//	--------------- Delete Product ------------------
	@GetMapping(value = "deleteProduct")
	public String deleteProduct(HttpServletRequest request) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		productService.deleteProduct(id);
		
		return "redirect:allProducts";
	
	}
	
	
//	--------------- Update Product ------------------
	@GetMapping(value = "updateProduct")
	public String updateProductGet(HttpServletRequest request, ModelMap map) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Product product = productService.getProductById(id);	
		map.addAttribute("product", product);
		
		return "updateProduct";
		
	}
	
}

