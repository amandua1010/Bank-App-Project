package com.bankapp.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bankapp_table_account")
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
	
	private Double accountBalance;
	
	@OneToOne(mappedBy = "account")
    private Customer customer;
	
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Transaction> transactionList = new ArrayList<>();
    
    public Account() {
    	
    }
    
    public Account(Integer accountId, Double accountBalance, Customer customer, List<Transaction> transactionList) {
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.customer = customer;
		this.transactionList = transactionList;
	}
    
	public Account(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
    
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountId=");
		builder.append(accountId);
		builder.append(", accountBalance=");
		builder.append(accountBalance);
		builder.append("]");
		return builder.toString();
	}
	
}
