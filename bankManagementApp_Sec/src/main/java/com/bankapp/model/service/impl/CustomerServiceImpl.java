package com.bankapp.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.CustomerDao;
import com.bankapp.model.service.CustomerService;
import com.bankapp.web.entities.Customer;
import com.bankapp.web.exceptions.CustomerNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	@Override
	public Customer deleteCustomer(Integer id) {
		
		Customer customerToDelete = getCustomerById(id);
		customerDao.delete(customerToDelete);
		
		return customerToDelete;
		
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {
		
		Customer customerToUpdate = getCustomerById(id);
		
		customerToUpdate.setCustomerAddress(customer.getCustomerAddress());
		customerToUpdate.setCustomerEmail(customer.getCustomerEmail());
		customerToUpdate.setCustomerName(customer.getCustomerName());
		customerToUpdate.setCustomerPhone(customer.getCustomerPhone());
//		customerToUpdate.setCustomerAadhar(customer.getCustomerAadhar());
//		customerToUpdate.setCustomerPAN(customer.getCustomerPAN());
		
		customerDao.save(customerToUpdate);
		
		return customerToUpdate;
		
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerDao.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with the following id: " + id + " is not found"));
	}

}
