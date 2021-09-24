package com.bankapp.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.web.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	public List<User> findUserByProfile(String profile);
	
	public User findUserByEmail(String email);
	
	public User findUserByUsername(String username);
	
}
