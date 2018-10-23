/**
 * 
 */
package com.springcloud.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author qianh
 *
 */
@Service
public class ConsumerService {

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
