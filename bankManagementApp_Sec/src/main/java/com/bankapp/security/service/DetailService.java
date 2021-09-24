package com.bankapp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.model.service.UserService;
import com.bankapp.web.entities.User;

@Service
public class DetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findUserByUsername(username); 	// need to change this for email only
		
		if (user == null) {
			throw new UsernameNotFoundException("The user is not found");		// this is the SpringSec exception not ours
		}

		return new SecurityUser(user);
		
	}
	
}
