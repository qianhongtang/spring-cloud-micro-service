package com.wisdontech.wisdontech.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WisdontechEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WisdontechEurekaClientApplication.class, args);
	}
}
