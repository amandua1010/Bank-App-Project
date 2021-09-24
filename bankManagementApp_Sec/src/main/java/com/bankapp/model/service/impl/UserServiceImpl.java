package com.bankapp.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.service.UserService;
import com.bankapp.web.entities.User;
import com.bankapp.web.exceptions.EmployeeNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	@Override
	public List<User> getAllEmployees() {
		return userDao.findUserByProfile("ROLE_CLERK");
	}

	@Override
	public User addEmployee(User user) {
		
		user.setProfile("ROLE_CLERK");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
		
	}

	@Override
	public User deleteEmployee(Integer id) {
		
		User employeeToDelete = getEmployeeById(id);
		userDao.delete(employeeToDelete);
		
		return employeeToDelete;
		
	}

	@Override
	public User updateEmployee(Integer id, Double salary) {
		
		User employeeToUpdate = getEmployeeById(id);
		employeeToUpdate.setSalary(salary);
		
		userDao.save(employeeToUpdate);
		
		return employeeToUpdate;
	
	}

	@Override
	public User getEmployeeById(Integer id) {
		return userDao.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with the following id: " + id + " is not found"));
	}


	@Override
	public User findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}


	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

}
