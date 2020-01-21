package com.anz.accounts.services.business;

import java.util.List;

import com.anz.accounts.exception.BusinessException;
import com.anz.accounts.model.AccountSummary;
import com.anz.accounts.model.TransactionDetails;

public interface AccountBusinessService {

	public List<AccountSummary> getAccounts() throws BusinessException;

	public List<TransactionDetails> getTransactionHistory(String accountNumber) throws BusinessException;
}