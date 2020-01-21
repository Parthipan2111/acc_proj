package com.anz.accounts.model;

import java.util.List;

public class AccountResponse {

	private String status;
	private List<AccountSummary> accounts;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AccountSummary> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountSummary> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "AccountListResponse [status=" + status + "]";
	}

}
