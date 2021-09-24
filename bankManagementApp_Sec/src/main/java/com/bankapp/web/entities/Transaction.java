package com.bankapp.web.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bankapp_table_transactions")
public class Transaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private String transactionType;
    private Double amount;
    private String status;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_fk")
    private Account account;

	public Transaction(Integer fromAccountNumber, Integer toAccountNumber, String transactionType, Double amount, String status) {
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [transactionId=");
		builder.append(transactionId);
		builder.append(", fromAccountNumber=");
		builder.append(fromAccountNumber);
		builder.append(", toAccountNumber=");
		builder.append(toAccountNumber);
		builder.append(", transactionType=");
		builder.append(transactionType);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
