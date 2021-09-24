package com.bankapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankapp.model.service.UserService;
import com.bankapp.web.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
//	--------------- get All Employees ------------------
	@GetMapping(value = "showAllEmployees")
	public String showAllEmployees(ModelMap map) {
		
		map.addAttribute("employees", userService.getAllEmployees());
		return "showAllEmployees";
		
	}

	
//	--------------- Add new Employee ------------------
	// GET method
	@GetMapping(value = "addEmployee")
	public String addEmployeeGet(ModelMap map) {
		
		map.addAttribute("employee", new User());
		return "addEmployee";
	
	}
	
	// POST method
	@PostMapping(value = "addEmployee")
	public String addEmployeePost(@Valid @ModelAttribute(name = "employee") User user, BindingResult result, ModelMap map) {
		
		if(result.hasErrors()) {
			return "addEmployee";
		}
		
		Integer id = user.getUserId();
		
		if(id == 0) {
			userService.addEmployee(user);
		}
		
		else {
			userService.updateEmployee(id, user.getSalary());
		}
	
		return "redirect:showAllEmployees";
		
	}
	
	
//	--------------- Delete Employee ------------------
	@GetMapping(value = "deleteEmployee")
	public String deleteEmployee(@RequestParam(name="id") int id) {
		
		userService.deleteEmployee(id);
		return "redirect:showAllEmployees";
		
	}
	
	
//	--------------- Update Employee ------------------
	@GetMapping(value = "updateEmployee")
	public String updateEmployee(@RequestParam(name="id") int id, ModelMap map) {
		
		map.addAttribute("employee", userService.getEmployeeById(id));
		return "updateEmployee";
	
	}

}
