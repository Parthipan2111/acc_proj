package com.anz.accounts.services.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anz.accounts.entity.Account;
import com.anz.accounts.entity.Transaction;
import com.anz.accounts.exception.BusinessException;
import com.anz.accounts.repository.AccountRepository;
import com.anz.accounts.services.dataaccess.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	private static final Logger LOGGER = LogManager.getLogger(AccountDAOImpl.class);

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	EntityManager em;

	/* Retrieve the account list from in-memory database h2 */
	@Override
	public List<Account> getAccountList() throws BusinessException {

		LOGGER.info("START :: AccountSummaryDAOImpl:getAccountList");
		List<Account> accountsList = null;
		try {

			accountsList = (List<Account>) accountRepository.findAll();
		} catch (Exception e) {
			LOGGER.error("Error while retreving account data");
			throw new BusinessException("Error while retreving account data");
		}

		LOGGER.info("END :: AccountSummaryDAOImpl:getAccountList");

		return accountsList;
	}

	/* Retrieve the account Transaction history list from in-memory database h2 */
	@Override
	public List<Transaction> getTransactionHistory(String accountNumber) throws BusinessException {
		LOGGER.info("START :: AccountSummaryDAOImpl:getTransactionHistory");

		List<Transaction> resultList = null;

		try {
			Query query = em.createNativeQuery("select * from transaction_history where id=:id",
					Transaction.class);
			query.setParameter("id", accountNumber);
			resultList = query.getResultList();
		} catch (Exception e) {
			LOGGER.error("Error while retreving account transaction data");
			throw new BusinessException("Error while retreving account transaction data");
		}
		LOGGER.info("END :: AccountSummaryDAOImpl:getTransactionHistory");

		return resultList;

	}

}