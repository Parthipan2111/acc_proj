package com.anz.accounts.services.business.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.accounts.entity.Account;
import com.anz.accounts.entity.Transaction;
import com.anz.accounts.exception.BusinessException;
import com.anz.accounts.model.AccountSummary;
import com.anz.accounts.model.TransactionDetails;
import com.anz.accounts.services.business.AccountBusinessService;
import com.anz.accounts.services.dataaccess.AccountDAO;
import com.anz.accounts.utils.AccountUtils;

@Service
public class AccountBusinessServiceImpl implements AccountBusinessService {

	private static final Logger LOGGER = LogManager.getLogger(AccountBusinessServiceImpl.class);

	@Autowired
	AccountDAO accountDAO;

	@Override
	public List<AccountSummary> getAccounts() throws BusinessException {
		LOGGER.info("START :: AccountBusinessServiceImpl:getAccounts");

		List<AccountSummary> accounts = new ArrayList<AccountSummary>();
		try {
			List<Account> accountList = accountDAO.getAccountList();
			if (null != accountList && !accountList.isEmpty()) {
				accountList.forEach(p -> {
					AccountSummary account = new AccountSummary();
					account.setAccountNumber(p.getAccountNumber());
					account.setAccountName(p.getAccountName());
					if (null != p.getAccountType() && "S".equalsIgnoreCase(p.getAccountType())) {
						account.setAccountType("Savings");
					} else {
						account.setAccountType("Current");
					}
					account.setCurrency(p.getCurrency());
					account.setAvilableBalance(
							AccountUtils.numberFormat(p.getAvilableBalance()));
					account.setBalanceDate(
							AccountUtils.convetDateFormat(new Date(p.getBalanceDate().getTime()), DateFormat.SHORT));
					accounts.add(account);
				});
			}
		} catch (Exception e) {
			LOGGER.error("Error while retrieving Accounts");
			throw new BusinessException("Error while retrieving Accounts");
		}

		LOGGER.info("END :: AccountBusinessServiceImpl:getAccounts");

		return accounts;
	}

	@Override
	public List<TransactionDetails> getTransactionHistory(String accountNumber) throws BusinessException {
		LOGGER.info("START :: AccountBusinessServiceImpl:getTransactionHistory");

		List<TransactionDetails> transactionhistory = new ArrayList<TransactionDetails>();

		try {
			List<Transaction> transactions = accountDAO.getTransactionHistory(accountNumber);
			if(null!=transactions && !transactions.isEmpty()){
			transactions.forEach(tranHist -> {
				TransactionDetails transaction = new TransactionDetails();
				transaction.setAccountName(tranHist.getAccountName());
				transaction.setAccountNumber(AccountUtils.textFormat(String.valueOf(tranHist.getAccountNumber())));
				transaction.setCreditedAmount(AccountUtils.numberFormat(tranHist.getCreditAmount()));
				transaction.setCurrency(tranHist.getCurrency());
				transaction.setTransacationType(tranHist.getTransactionType());
				if (null != tranHist.getTransactionType() && "C".equalsIgnoreCase(tranHist.getTransactionType())) {
					transaction.setTransacationType("Credit");
				} else {
					transaction.setTransacationType("Debit");
				}
				transaction.setTransactionNarrative(tranHist.getTransactionNarrative());
				transaction.setDebitedAmount(tranHist.getDebitAmount().toString());
				transaction.setValueDate(
						AccountUtils.convetDateFormat(new Date(tranHist.getValueDate().getTime()), DateFormat.MEDIUM));
				transactionhistory.add(transaction);
			});
			}
		} catch (Exception e) {
			LOGGER.error("Error while retrieving Accounts Transaction History");
			throw new BusinessException("Error while retrieving Accounts Transaction History");
		}
		LOGGER.info("END :: AccountBusinessServiceImpl:getTransactionHistory");

		return transactionhistory;
	}

}
