/**
 * 
 */
package com.springcloud.zuul.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wisdontech.common.dto.ResultDto;

/**
 * @author qianh
 *
 */
@FeignClient("oauth2-authentication-server")
public interface Oauth2Service {

	@GetMapping("/oauth/check-token")
	ResultDto<?> checkToken(@RequestParam String token);
}
