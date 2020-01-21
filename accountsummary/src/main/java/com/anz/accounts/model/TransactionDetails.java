package com.anz.accounts.model;

import java.math.BigDecimal;

public class TransactionDetails {
	private String accountNumber;
	private String accountName;
	private String valueDate;
	private String currency;
	private String debitedAmount;

	public String getDebitedAmount() {
		return debitedAmount;
	}

	public void setDebitedAmount(String debitedAmount) {
		this.debitedAmount = debitedAmount;
	}

	public String getCreditedAmount() {
		return creditedAmount;
	}

	public void setCreditedAmount(String creditedAmount) {
		this.creditedAmount = creditedAmount;
	}

	private String creditedAmount;
	private String transacationType;
	private String transactionNarrative;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTransacationType() {
		return transacationType;
	}

	public void setTransacationType(String transacationType) {
		this.transacationType = transacationType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	@Override
	public String toString() {
		return "Transaction [accountNumber=" + accountNumber + ", accountName=" + accountName + ", valueDate="
				+ valueDate + ", currency=" + currency + ", debitedAmount=" + debitedAmount + ", creditedAmount="
				+ creditedAmount + ", transacationType=" + transacationType + ", transactionNarrative="
				+ transactionNarrative + "]";
	}

}
