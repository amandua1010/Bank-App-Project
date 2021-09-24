package com.bankapp.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.TransactionDao;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.entities.Transaction;
import com.bankapp.web.exceptions.AccountNotFoundException;
import com.bankapp.web.exceptions.NotSufficientBalanceException;
import com.bankapp.web.exceptions.TransactionNotFoundException;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	private TransactionDao transactionDao;
	private AccountService accountService;
	
	@Autowired
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	
	@Override
	public List<Transaction> getAllTransactions() {
		return transactionDao.findAll();
	}
	
	@Override
	public Transaction getTransactionById(int id) {
		return transactionDao.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction with the following id: " + id + " is not found"));
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	public Transaction updateTransaction(int id, String status) {
		
		Transaction transactionToUpdate = getTransactionById(id);
		transactionToUpdate.setStatus(status);
		
		transactionDao.save(transactionToUpdate);
		
		return transactionToUpdate;
	}
	
	
//	--------------- Deposit Money ------------------
	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, NotSufficientBalanceException.class })
	public void depositMoney(Integer toAccountNumber, Double amount) {
		
		Account account = accountService.getAccountById(toAccountNumber);
		
		Transaction transaction = new Transaction(null, toAccountNumber, "DEPOSIT", amount, "SUCCESS");
		
		account.getTransactionList().add(transaction);
		transaction.setAccount(account);
		
		// total updated amount
		accountService.updateAccount(toAccountNumber, account.getAccountBalance() + amount);
		
	}
	
	
//	--------------- Withdraw Money ------------------
	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, NotSufficientBalanceException.class })
	public void withdrawMoney(Integer fromAccountNumber, Double amount) {
		
		Account account = accountService.getAccountById(fromAccountNumber);
		
		if (account.getAccountBalance() >= amount) {
			
			Transaction transaction = new Transaction(fromAccountNumber, null, "WITHDRAW", amount, "SUCCESS");
			
			transaction.setAccount(account);
			account.getTransactionList().add(transaction);
			
			// total updated amount
			accountService.updateAccount(fromAccountNumber, account.getAccountBalance() - amount);
		
		} 
		
		else {
			throw new NotSufficientBalanceException("The following Account Number: " + fromAccountNumber + " does not have enough balance");
		}
		
	}
	
	
//	--------------- Transfer Money ------------------
	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, NotSufficientBalanceException.class })
	public void transferMoney(Integer fromAccountNumber, Integer toAccountNumber, Double amount) {
		
		Account fromAccount = accountService.getAccountById(fromAccountNumber);
		
		if (fromAccount.getAccountBalance() >= amount) {

			Account toAccount = accountService.getAccountById(toAccountNumber);

			if (amount >= 200000) {				// limit amount for transfer is less than 200000
				
				Transaction transaction = new Transaction(fromAccountNumber, toAccountNumber, "TRANSFER", amount, "PENDING");
				transaction.setAccount(fromAccount);
				
				addTransaction(transaction);
			
			} 
			
			else {
				
				Transaction transaction = new Transaction(fromAccountNumber, toAccountNumber, "TRANSFER", amount, "SUCCESS");
				
				fromAccount.getTransactionList().add(transaction);
				
				accountService.updateAccount(fromAccountNumber, fromAccount.getAccountBalance() - amount);		// withdraw
				
				accountService.updateAccount(toAccountNumber, toAccount.getAccountBalance() + amount);			// deposit
			
			}

		} 
		
		else {
			throw new NotSufficientBalanceException("The following Account Number: " + fromAccountNumber + " does not have enough balance");
		}
		
	}
	
	@Override
	public List<Transaction> accountPassbook(Integer accountNumber) {
		
		List<Transaction> list1 = transactionDao.findByFromAccountNumber(accountNumber);		// when money was withdrawn in the account
				
		List<Transaction> list2 = transactionDao.findByToAccountNumber(accountNumber);		// when money was deposited in the account
				
		list1.addAll(list2);
		
		return list1;
		
	}

	@Override
	public List<Transaction> getTransactionListByStatus(String status) {
		return transactionDao.findByStatus(status);
	}
	
	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, TransactionNotFoundException.class, NotSufficientBalanceException.class })
	public void approvePendingTransaction(Integer id) {
		
		Transaction transaction = getTransactionById(id);
		
		Double amount = transaction.getAmount();

		Integer fromAccountNumber = transaction.getFromAccountNumber();
		Integer toAccountNumber = transaction.getToAccountNumber();

		Account fromAccount = accountService.getAccountById(fromAccountNumber);
		Account toAccount = accountService.getAccountById(toAccountNumber);

		if (fromAccount.getAccountBalance() >= amount) {
			
			accountService.updateAccount(fromAccountNumber, fromAccount.getAccountBalance() - amount);
			
			accountService.updateAccount(toAccountNumber, toAccount.getAccountBalance() + amount);
			
			transaction.setStatus("SUCCESS");
			
			addTransaction(transaction);
		
		} 
		
		else {
			throw new NotSufficientBalanceException("The following Account Number: " + fromAccountNumber + " does not have enough balance");
		}
		
	}

	@Override
	public void rejectPendingTransaction(Integer id) {
		
		Transaction transaction = getTransactionById(id);
		
		transaction.setStatus("REJECTED");
		
		addTransaction(transaction);
		
	}

}


