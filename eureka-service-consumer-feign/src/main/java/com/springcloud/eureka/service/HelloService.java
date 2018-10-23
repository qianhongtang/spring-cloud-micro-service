/**
 * 
 */
package com.springcloud.eureka.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qianh
 *
 */
@FeignClient("service-client-eureka")
public interface HelloService {

	@GetMapping("/info")
	String hello();
}
