/**
 * 
 */
package com.wisdontech.wisdontech.consul.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qianh
 *
 */
@FeignClient("service-client-consul")
public interface HelloService {

	@GetMapping("/info")
	String hello();
}
