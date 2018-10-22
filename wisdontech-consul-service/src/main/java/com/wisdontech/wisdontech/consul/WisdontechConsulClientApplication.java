package com.wisdontech.wisdontech.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WisdontechConsulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WisdontechConsulClientApplication.class, args);
	}
}
