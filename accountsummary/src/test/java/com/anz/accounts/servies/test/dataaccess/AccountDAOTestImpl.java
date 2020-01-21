package com.anz.accounts.servies.test.dataaccess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.anz.accounts.entity.Account;
import com.anz.accounts.entity.Transaction;
import com.anz.accounts.exception.BusinessException;
import com.anz.accounts.services.dataaccess.impl.AccountDAOImpl;

@SpringBootTest
public class AccountDAOTestImpl {

	@Mock
	AccountDAOImpl accountDAO;

	private List<Account> loadAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account(1235469877, "Saving2356", "S", java.sql.Date.valueOf("2018-12-12"), "AUD",
				BigDecimal.valueOf(5681.03)));
		accountList.add(new Account(1235469878, "Saving1234", "S", Date.valueOf("2018-12-12"), "AUD",
				BigDecimal.valueOf(9865.04)));

		accountList.add(new Account(1235469879, "Current897", "C", Date.valueOf("2018-12-12"), "AUD",
				BigDecimal.valueOf(438.04)));

		return accountList;
	}

	private List<Transaction> loadTransactionData() {

		List<Transaction> result = new ArrayList<Transaction>();
		result.add(new Transaction(12, 1234569877, "Savings2356", Date.valueOf("2018-12-12"), "SVG", BigDecimal.ZERO,
				BigDecimal.valueOf(12365.6), "C", "new credit"));
		result.add(new Transaction(12, 1234569877, "Savings2356", Date.valueOf("2018-12-12"), "AUD", BigDecimal.ZERO,
				BigDecimal.valueOf(1456.6), "C", "new credit"));
		return result;
	}

	@BeforeEach
	void setMockResponse() {
		try {
			when(accountDAO.getAccountList()).thenReturn(loadAccounts());
			when(accountDAO.getTransactionHistory("123654")).thenReturn(loadTransactionData());
		} catch (BusinessException e) {
		}
	}

	@Test

	void testAccounts() {
		try {
			System.out.println(accountDAO.getAccountList().size());
			assertEquals(true, !accountDAO.getAccountList().isEmpty());
			assertEquals(3, accountDAO.getAccountList().size());
		} catch (BusinessException e) {
		}
	}

	@Test
	void testAccountsTransaction() {
		try {
			System.out.println(accountDAO.getTransactionHistory("123654").size());

			assertEquals(true, !accountDAO.getTransactionHistory("123654").isEmpty());
			assertEquals(2, accountDAO.getTransactionHistory("123654").size());
		} catch (BusinessException e) {
		}

	}
}
