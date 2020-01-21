package com.anz.accounts.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anz.accounts.exception.BusinessException;
import com.anz.accounts.model.AccountResponse;
import com.anz.accounts.model.AccountSummary;
import com.anz.accounts.model.AccountTransationResponse;
import com.anz.accounts.model.TransactionDetails;
import com.anz.accounts.services.business.AccountBusinessService;

@RestController
@Validated
public class AccountController {

	private static final Logger LOGGER = LogManager.getLogger(AccountController.class);

	@Autowired
	AccountBusinessService accountService;

	/* Method to retrieve list of Accounts */
	@GetMapping("/accounts")
	public AccountResponse getAccounts() {
		LOGGER.info("START :: AccountSummaryController:getAccounts");

		AccountResponse accountListResponse = new AccountResponse();
		List<AccountSummary> result = null;
		try {
			result = accountService.getAccounts();
			accountListResponse.setAccounts(result);
			accountListResponse.setStatus("SUCCESS");
		} catch (BusinessException e) {
			LOGGER.error("Error Occured during getAccount");
			accountListResponse.setStatus("ERROR");
		}
		LOGGER.info("END :: AccountSummaryController:getAccounts");

		return accountListResponse;

	}
	
	/* Method to retrieve the TransactionHistory */

	@GetMapping("/transactionhistory/{accountId}")
	public AccountTransationResponse getTransacionHistory(
			@PathVariable(name = "accountId", required = true) @NotBlank @Size(min=10, max=10) String accountId) {

		LOGGER.info("START :: AccountSummaryController:getTransacionHistory");

		AccountTransationResponse accountTransactionResponse = new AccountTransationResponse();
		List<TransactionDetails> result = null;

		try {
			result = accountService.getTransactionHistory(accountId);
			accountTransactionResponse.setTransactions(result);
			accountTransactionResponse.setStatus("SUCCESS");
		} catch (BusinessException e) {
			LOGGER.error("Error Occured during getTransactionHistory");
			accountTransactionResponse.setStatus("ERROR");
		}

		LOGGER.info("END :: AccountSummaryController:getTransacionHistory");

		return accountTransactionResponse;

	}

}
