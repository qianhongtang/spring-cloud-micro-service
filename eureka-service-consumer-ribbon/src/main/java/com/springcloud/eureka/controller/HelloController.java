package com.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Value("${spring.application.name}")
	private String serviceName;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hello/{username}")
	public String hello(@PathVariable String username, @RequestParam String accessToken) {
		String user = restTemplate.getForObject("http://{serviceName}/info/{username}?access_token={accessToken}",
				String.class, serviceName, username, accessToken);
		return user;
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
