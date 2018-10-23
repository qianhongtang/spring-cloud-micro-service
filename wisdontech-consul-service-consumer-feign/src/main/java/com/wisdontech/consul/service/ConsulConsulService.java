/**
 * 
 */
package com.wisdontech.consul.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qianh
 *
 */
@FeignClient("consul-service")
public interface ConsulConsulService {

	@GetMapping("/info")
	String info();
}
