package com.bankapp.model.service;

import java.util.List;

import com.bankapp.web.entities.Transaction;

public interface TransactionService {

	public List<Transaction> getAllTransactions();
	
	public Transaction getTransactionById(int id);

	public Transaction addTransaction(Transaction transaction);

	public Transaction updateTransaction(int id, String status);

	public List<Transaction> accountPassbook(Integer accountNumber);

	public void depositMoney(Integer toAccountNumber, Double amount);

	public void withdrawMoney(Integer fromAccountNumber, Double amount);
	
	public void transferMoney(Integer fromAccountNumber, Integer toAccountNumber, Double amount);
	
	public List<Transaction> getTransactionListByStatus(String status);

	public void approvePendingTransaction(Integer id);
	
	public void rejectPendingTransaction(Integer id);

}
