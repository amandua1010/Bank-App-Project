package com.bankapp.model.service;

import java.util.List;

import com.bankapp.web.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();

	public Customer addCustomer(Customer customer);
	
	public Customer deleteCustomer(Integer id);

	public Customer updateCustomer(Integer id, Customer customer);

	public Customer getCustomerById(Integer id);
	
}
