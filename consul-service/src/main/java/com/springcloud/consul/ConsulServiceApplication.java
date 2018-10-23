package com.springcloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulServiceApplication.class, args);
	}
}
