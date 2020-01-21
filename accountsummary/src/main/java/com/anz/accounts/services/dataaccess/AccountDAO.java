package com.anz.accounts.services.dataaccess;

import java.util.List;

import com.anz.accounts.entity.Account;
import com.anz.accounts.entity.Transaction;
import com.anz.accounts.exception.BusinessException;

public interface AccountDAO {

	public List<Account> getAccountList() throws BusinessException;

	public List<Transaction> getTransactionHistory(String accountNumber) throws BusinessException;
}