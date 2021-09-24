package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.entities.Customer;
import com.bankapp.web.entities.User;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootJspBankManagementAppApplication implements CommandLineRunner {

	private CustomerService customerService;
	private UserService userService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJspBankManagementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Customer customer1 = new Customer("aman", "7727272222", "Delhi", "aman09@gmail.com", "21022123", "ABC364J");
//		
//		Account account1 = new Account(21000.0);
//		customer1.setAccount(account1);
//		account1.setCustomer(customer1);
//		
//		customerService.addCustomer(customer1);
//
//		
//		User user1 = new User("abc", "abc@gmail.com", "abc123", "8788762124", "ROLE_MGR", 90000.0);
//		userService.addEmployee(user1);
		
	
		
//		User user2 = new User("xyz", "xyz@gmail.com", "xyz789", "9977621249", "ROLE_CLERK", 89000.0);
//		userService.addEmployee(user2);
		
	}

}
