package com.anz.accounts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("parthi").password("{noop}password").roles("USER");
	}

	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/accounts").hasRole("USER")
			.antMatchers(HttpMethod.GET, "/transactionhistory/***").hasRole("USER")
			.and().csrf().disable()
			.formLogin().disable();

	}
}
