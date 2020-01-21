package com.anz.accounts.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_HISTORY")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	@Column(name = "ID")
	private long accountNumber;
	@Column(name = "NAME")
	private String accountName;
	private Date valueDate;
	private String currency;
	private BigDecimal debitAmount;
	private BigDecimal creditAmount;
	private String transactionType;
	private String transactionNarrative;
	
	
	public Transaction(){
		
	}

	public Transaction(long transactionId, long accountNumber, String accountName, Date valueDate,
			String currency, BigDecimal debitAmount, BigDecimal creditAmount, String transactionType,
			String transactionNarrative) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.valueDate = valueDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transactionType = transactionType;
		this.transactionNarrative = transactionNarrative;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transacationType) {
		this.transactionType = transacationType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", accountName=" + accountName + ", valueDate=" + valueDate + ", currency=" + currency
				+ ", debitAmount=" + debitAmount + ", creditAmount=" + creditAmount + ", transacationType="
				+ transactionType + ", transactionNarrative=" + transactionNarrative + "]";
	}

}
