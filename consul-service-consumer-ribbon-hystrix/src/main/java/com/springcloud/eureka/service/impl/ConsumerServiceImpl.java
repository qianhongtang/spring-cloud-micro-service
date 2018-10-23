/**
 * 
 */
package com.springcloud.eureka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.eureka.service.ConsumerService;

/**
 * @author qianh
 *
 */
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public String consumer() {
		return restTemplate.getForObject("http://consul-service/hystrix", String.class);
	}

	public String fallback() {
		return "fallback";
	}
}
