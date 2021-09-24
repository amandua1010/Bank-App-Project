package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankapp.model.service.CustomerService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.entities.Customer;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
//	--------------- get All Customers ------------------
	@GetMapping(value = "showAllCustomers")
	public String showAllCustomers(ModelMap map) {
		
		map.addAttribute("customers", customerService.getAllCustomers());
		return "showAllCustomers";
		
	}
	
	
//	--------------- Add new Customer ------------------
	// GET method
	@GetMapping(value = "addCustomer")
	public String addCustomerGet(ModelMap map) {
		
		map.addAttribute("customer", new Customer());
		return "addCustomer";
	
	}
	
	// POST method
	@PostMapping(value = "addCustomer")
	public String addCustomerPost(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult result, HttpServletRequest request, ModelMap map) {
		
		if(result.hasErrors()) {
			return "addCustomer";
		}
		
		Integer id = customer.getCustomerId();
		
		if(id == 0) {
			
			Double balance = Double.parseDouble(request.getParameter("accountBalance"));
			
			Account account = new Account(balance);
			customer.setAccount(account);
			account.setCustomer(customer);
			
			customerService.addCustomer(customer);
			
		}
		
		else {
			customerService.updateCustomer(id, customer);
		}
		
		return "redirect:showAllCustomers";
		
	}
	
	
//	--------------- Delete Customer ------------------
	@GetMapping(value = "deleteCustomer")
	public String deleteCustomer(HttpServletRequest request) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		customerService.deleteCustomer(id);
		
		return "redirect:showAllCustomers";
	
	}
	
	
//	--------------- Update Customer ------------------
	@GetMapping(value = "updateCustomer")
	public String updateCustomerGet(HttpServletRequest request, ModelMap map) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerService.getCustomerById(id);
		
		map.addAttribute("customer", customer);
		
		return "updateCustomer";
		
	}
	
}
