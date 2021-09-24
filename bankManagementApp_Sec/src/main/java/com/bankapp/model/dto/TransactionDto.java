package com.bankapp.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransactionDto {
	
	@NotNull(message="From Account Number cannot be empty")
	private Integer fromAccountNumber;
	
	@NotNull(message="To Account Number cannot be empty")
	private Integer toAccountNumber;
	
	@NotNull(message="Amount cannot be empty")
	@Min(value=100, message="Minimum amount is 100")
	@Max(value=100000, message="Maximum amount is 100000")
	private Double amount;
	
	public TransactionDto() {
		
	}
	
	public TransactionDto(Integer fromAccountNumber, Integer toAccountNumber, Double amount) {
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
	}

	public Integer getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(Integer fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public Integer getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(Integer toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionDto [fromAccountNumber=");
		builder.append(fromAccountNumber);
		builder.append(", toAccountNumber=");
		builder.append(toAccountNumber);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
}
