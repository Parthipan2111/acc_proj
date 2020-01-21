package com.anz.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class AccountSummaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountSummaryApplication.class, args);
	}

}
