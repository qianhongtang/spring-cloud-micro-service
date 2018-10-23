package com.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.consumer.service.ConsumerService;

@RestController
public class HelloController {

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/my-info")
	public String myInfo() {
		String services = "Hello Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}

	@Autowired
	ConsumerService consumerService;

	@GetMapping("/consumer")
	public String consumer() {
		return consumerService.consumer();
	}

//	@Autowired
//	ConsulService consulService;
//
//
//	@GetMapping("/info")
//	public String info() {
//		return consulService.info();
//	}

}
