package com.wisdontech.wisdontech.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdontech.wisdontech.consul.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;

	@GetMapping("/hello")
	public String hello() {
		return helloService.hello();
	}

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/info")
	public String info() {
		String services = "Hello Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
