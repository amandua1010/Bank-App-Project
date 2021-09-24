package com.bankapp.model.service;

import java.util.List;

import com.bankapp.web.entities.Account;

public interface AccountService {

	public List<Account> getAllAccounts();

	public Account getAccountById(Integer id);

	public Account addAccount(Account account);

	public Account updateAccount(Integer id, Double balance);
	
	public Double getAccountBalance(Integer id);

}
