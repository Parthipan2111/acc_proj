
package com.anz.accounts.model;

public class AccountSummary {

	private long accountNumber;
	private String accountName;
	private String accountType;
	private String balanceDate;
	private String currency;
	private String avilableBalance;

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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAvilableBalance() {
		return avilableBalance;
	}

	public void setAvilableBalance(String avilableBalance) {
		this.avilableBalance = avilableBalance;
	}

	@Override
	public String toString() {
		return "AccountSummary [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountType="
				+ accountType + ", balanceDate=" + balanceDate + ", currency=" + currency + ", avilableBalance="
				+ avilableBalance + "]";
	}

}