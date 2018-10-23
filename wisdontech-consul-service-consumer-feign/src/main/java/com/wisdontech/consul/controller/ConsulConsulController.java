package com.wisdontech.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdontech.consul.service.ConsulConsulService;

@RestController
public class ConsulConsulController {

	@Autowired
	ConsulConsulService consulConsulService;

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/service-info")
	public String hello() {
		return consulConsulService.info();
	}

	@GetMapping("/my-info")
	public String info() {
		String services = "Hello Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
