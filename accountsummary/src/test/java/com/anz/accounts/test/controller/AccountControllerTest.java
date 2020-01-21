package com.anz.accounts.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void getAccoutsTest() throws RestClientException, MalformedURLException {
		TestRestTemplate testRestTemplate= new TestRestTemplate("parthi", "password");
		ResponseEntity<String> response = testRestTemplate.getForEntity(new URL("http://localhost:" + port + "/accounts").toString(), String.class);
        
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
	
	@Test
	public void getAccoutsTest_Without_Credential() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/accounts").toString(), String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

	}
	
	@Test
	public void getAccoutHistoryTest() throws RestClientException, MalformedURLException {
		TestRestTemplate testRestTemplate= new TestRestTemplate("parthi", "password");
		ResponseEntity<String> response = testRestTemplate.getForEntity(new URL("http://localhost:" + port + "/transactionhistory/1234567891").toString(), String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void getAccoutsHistoryTest_Without_Credential() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/transactionhistory/1234567891").toString(), String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

	}

}
