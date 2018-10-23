package com.springcloud.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.consul.service.ConsulService;

@RestController
public class ConsumerFeignController {

	@Autowired
	ConsulService consulService;

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/info")
	public String info() {
		return consulService.info();
	}

	@GetMapping("/hystrix")
	public String hystrix() {
		return consulService.hystrix();
	}

	@GetMapping("/my-info")
	public String myInfo() {
		String services = "Hello Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
