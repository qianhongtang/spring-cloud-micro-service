package com.springcloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulConfigClientApplication.class, args);
	}
}
