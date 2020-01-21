package com.anz.accounts.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_LIST")
public class Account {
	@Id
	@Column(name = "ID")
	private long accountNumber;
	@Column(name = "NAME")
	private String accountName;
	@Column(name = "TYPE")
	private String accountType;
	private Date balanceDate;
	private String currency;
	@Column(name = "BALANCE")
	private BigDecimal avilableBalance;
	
	public Account(long accountNumber, String accountName, String accountType, Date balanceDate, String currency,
			BigDecimal avilableBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.avilableBalance = avilableBalance;
	}
	

	public Account(){
		
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAvilableBalance() {
		return avilableBalance;
	}

	public void setAvilableBalance(BigDecimal avilableBalance) {
		this.avilableBalance = avilableBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountType="
				+ accountType + ", balanceDate=" + balanceDate + ", currency=" + currency + ", avilableBalance="
				+ avilableBalance + "]";
	}

}