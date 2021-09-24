package com.bankapp.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "bankapp_table_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotEmpty(message="Employee Username cannot be empty")
	private String username;
	
	@NotEmpty(message="Employee Email cannot be empty")
	private String email;
	
	@NotEmpty(message="Employee Password cannot be empty")
	private String password;
	
	@NotEmpty(message="Employee Contact cannot be empty")
	private String phone;
	
	private String profile;
	
	@NotNull(message="Employee Salary cannot be empty")
	private Double salary;
	
	public User(String username, String email, String password, String phone, String profile, Double salary) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.profile = profile;
		this.salary = salary;
	}

}
