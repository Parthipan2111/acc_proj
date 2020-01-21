package com.anz.accounts.model;

import java.util.List;

public class AccountTransationResponse {

	private String status;
	private List<TransactionDetails> transactions;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TransactionDetails> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDetails> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AccountTransationResponse [status=" + status + ", transactions=" + transactions + "]";
	}

}
