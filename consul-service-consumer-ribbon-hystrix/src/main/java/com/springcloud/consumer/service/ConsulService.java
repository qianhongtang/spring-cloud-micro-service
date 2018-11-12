/**
 * 
 */
package com.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.springcloud.consumer.service.fallback.ConsulServiceFallBack;

/**
 * @author qianh
 *
 */
@FeignClient(name = "consul-service", fallback = ConsulServiceFallBack.class)
public interface ConsulService {

	@GetMapping("/info")
	String info();

	@GetMapping("/hystrix")
	String hystrix();

}
