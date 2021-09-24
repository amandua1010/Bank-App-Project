package com.bankapp.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.exceptions.AccountNotFoundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.findAll();
	}

	@Override
	public Account getAccountById(Integer id) {
		return accountDao.findById(id).orElseThrow(() -> new AccountNotFoundException("Account with the following id: " + id + " is not found"));
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.save(account);
	}

	@Override
	public Account updateAccount(Integer id, Double balance) {
		
		Account accountToUpdate = getAccountById(id);
		
		accountToUpdate.setAccountBalance(balance);
		accountDao.save(accountToUpdate);
		
		return accountToUpdate;
		
	}

	@Override
	public Double getAccountBalance(Integer id) {
		Account account = getAccountById(id);
		return account.getAccountBalance();
	}

}
