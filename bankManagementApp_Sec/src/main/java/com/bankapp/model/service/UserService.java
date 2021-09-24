package com.bankapp.model.service;

import java.util.List;

import com.bankapp.web.entities.User;

public interface UserService {
	
	public List<User> getAllEmployees();

	public User addEmployee(User user);

	public User deleteEmployee(Integer id);

	public User updateEmployee(Integer id, Double salary);
	
	public User getEmployeeById(Integer id);
	
	public User findUserByEmail(String email);
	
	public User findUserByUsername(String username);
	
}
