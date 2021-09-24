package com.bankapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankapp.model.dto.TransactionDto;
import com.bankapp.model.service.TransactionService;
import com.bankapp.security.service.SecurityUser;
import com.bankapp.web.entities.Transaction;

@Controller
@RequestMapping(path = "/transaction")
public class TransactionController {
	
	private TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
//	--------------- get All Transactions ------------------
	@GetMapping(value = "showAllTransactions")
	public String getAllTransaction(ModelMap map) {
		
		map.addAttribute("transactions", transactionService.getAllTransactions());
		return "showAllTransactions";
		
	}
	
//	--------------- Approve Transaction ------------------
	@GetMapping(value = "approveTransaction")
	public String approveTransaction(@RequestParam (name="id")Integer id) {
		
		transactionService.approvePendingTransaction(id);
		return "redirect:showAllTransactions";
		
	}
	
//	--------------- Pending Transaction ------------------
	@GetMapping(value = "pendingTransaction")
	public String getAllPendingTransaction(ModelMap map, @AuthenticationPrincipal SecurityUser secUser) {
		
		map.addAttribute("profile", secUser.getUser().getProfile());
		map.addAttribute("transactions", transactionService.getTransactionListByStatus("PENDING"));
		return "pendingTransaction";
		
	}
	
//	--------------- Reject Transaction ------------------
	@GetMapping(value = "rejectTransaction")
	public String rejectTransaction(@RequestParam (name="id")Integer id) {
		
		transactionService.rejectPendingTransaction(id);
		return "redirect:showAllTransactions";
	
	}
	
//	--------------- Deposit Money GET and POST ------------------
	@GetMapping(value = "depositMoney")
	public String depositMoneyGet(ModelMap map) {
		
		map.addAttribute("transactionDto", new TransactionDto());
		return "deposit";
	
	}
	
	// POST Method
	@PostMapping(value = "depositMoney")
	public String depositMoneyPost(@Valid @ModelAttribute(name = "transactionDto") TransactionDto transac, BindingResult result) {
		
		if(result.hasErrors() && result.getErrorCount() > 1) {
			return "deposit";
		}
		
		Integer toAccountNumber = transac.getToAccountNumber();
		
		Double depositAmount = transac.getAmount();

		transactionService.depositMoney(toAccountNumber, depositAmount);

		return "redirect:showAllTransactions";
		
	}
	
//	--------------- Withdraw Money GET and POST ------------------
	@GetMapping(value = "withdrawMoney")
	public String withdrawMoneyGet(ModelMap map) {
		
		map.addAttribute("transactionDto", new TransactionDto());
		return "withdraw";
		
	}

	// POST Method
	@PostMapping("withdrawMoney")
	public String withdrawMoneyPost(@Valid @ModelAttribute(name = "transactionDto") TransactionDto transac, BindingResult result) {
		
		if(result.hasErrors() && result.getErrorCount() > 1) {
			return "withdraw";
		}
		
		Integer fromAccountNumber = transac.getFromAccountNumber();
		
		Double withdrawAmount = transac.getAmount();
		
		transactionService.withdrawMoney(fromAccountNumber, withdrawAmount);
		
		return "redirect:showAllTransactions";
		
	}
	
//	--------------- Transfer Money GET and POST ------------------
	@GetMapping(value = "transferMoney")
	public String transferMoneyGet(ModelMap map) {
		
		map.addAttribute("transactionDto", new TransactionDto());
		return "transfer";
	
	}

	// POST Method
	@PostMapping(value = "transferMoney")
	public String transferMoneyPost(@Valid @ModelAttribute(name = "transactionDto") TransactionDto transac, BindingResult result) {
		
		if(result.hasErrors()) {
			return "transfer";
		}
		
		Integer fromAccountNumber = transac.getFromAccountNumber();
		Integer toAccountNumber = transac.getToAccountNumber();
		
		Double amount = transac.getAmount();

		transactionService.transferMoney(fromAccountNumber, toAccountNumber, amount);

		return "redirect:showAllTransactions";
		
	}
	
//	--------------- Account Passbook ------------------
	@GetMapping(value = "accountPassbook")
	public String getAccountPassbook(@RequestParam (name="id") int id, ModelMap map) {
		
		List<Transaction> accountPassbook = transactionService.accountPassbook(id);
		map.addAttribute("transactions", accountPassbook);
		
		return "showAllTransactions";
		
	}
	
}
