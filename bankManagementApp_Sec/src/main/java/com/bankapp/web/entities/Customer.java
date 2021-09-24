package com.bankapp.web.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "bankapp_table_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

//	@Size(min = 3, message = "Customer Name should be of atleast 3 characters")
	@NotEmpty(message="Customer Name cannot be empty")
	private String customerName;
	
	@NotEmpty(message="Customer Phone cannot be empty")
	private String customerPhone;
	
	@NotEmpty(message="Customer Address cannot be empty")
	private String customerAddress;
	
	@NotEmpty(message="Customer Email cannot be empty")
	private String customerEmail;
	
//	@Size(min = 8, message = "Customer Aadhar must be of atleast 8 characters")
	@NotEmpty(message="Customer Aadhar cannot be empty")
	private String customerAadhar;
	
//	@Size(min = 3, message = "Customer PAN must be of atleast 3 characters")
	@NotEmpty(message="Customer PAN cannot be empty")
	private String customerPAN;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_fk")
	private Account account;

	public Customer() {

	}
	
	public Customer(Integer customerId, String customerName, String customerPhone, String customerAddress,
			String customerEmail, String customerAadhar, String customerPAN, Account account) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerAadhar = customerAadhar;
		this.customerPAN = customerPAN;
		this.account = account;
	}

	public Customer(String customerName, String customerPhone, String customerAddress, String customerEmail, String customerAadhar, String customerPAN) {
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerAadhar = customerAadhar;
		this.customerPAN = customerPAN;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAadhar() {
		return customerAadhar;
	}

	public void setCustomerAadhar(String customerAadhar) {
		this.customerAadhar = customerAadhar;
	}

	public String getCustomerPAN() {
		return customerPAN;
	}

	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=");
		builder.append(customerId);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", customerPhone=");
		builder.append(customerPhone);
		builder.append(", customerAddress=");
		builder.append(customerAddress);
		builder.append(", customerEmail=");
		builder.append(customerEmail);
		builder.append(", customerAadhar=");
		builder.append(customerAadhar);
		builder.append(", customerPAN=");
		builder.append(customerPAN);
		builder.append("]");
		return builder.toString();
	}
	
}
