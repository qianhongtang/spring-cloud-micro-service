/**
 * 
 */
package com.springcloud.consul.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qianh
 *
 */
@FeignClient("consul-service")
public interface ConsulService {

	@GetMapping("/info")
	String info();

	@GetMapping("/hystrix")
	String hystrix();

}
