package com.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.springcloud.consumer.service.ConsulService;

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
	ConsulService consulService;

	@GetMapping("/info")
	public String info() {
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
				.getInstance(HystrixCommandKey.Factory.asKey("ConsulService#hystrix()"));
		if (breaker != null) {
			System.out.println("断路器状态：" + breaker.isOpen());
		}
		return consulService.info();
	}

	@GetMapping("/hystrix")
	public String hystrix() {
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
				.getInstance(HystrixCommandKey.Factory.asKey("ConsulService#hystrix()"));
		if (breaker != null) {
			System.out.println("断路器状态：" + breaker.isOpen());
		}
		return consulService.hystrix();
	}

}
