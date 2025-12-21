package com.ou_solutions.account_mgmt.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountMgmtServiceApplication.class, args);
	}

}
