package com.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.eureka.service.ConsulService;
import com.springcloud.eureka.service.ConsumerService;

@RestController
public class HelloController {

	@Value("${spring.application.name}")
	private String serviceName;

	@Autowired
	ConsumerService consumerService;

	@Autowired
	ConsulService consulService;

	@GetMapping("/consumer")
	public String consumer() {
		return consumerService.consumer();
	}

	@GetMapping("/info")
	public String info() {
		return consulService.info();
	}

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/my-info")
	public String myInfo() {
		String services = "Hello Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}

}
