package com.wisdontech.wisdontech.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wisdontech.common.dto.ResultDto;
import com.wisdontech.oauth.user.dto.UserDto;

@RestController
public class HelloController {

	@Autowired
	RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@GetMapping("/hello/{username}")
	public ResultDto<UserDto> hello(@PathVariable String username, @RequestParam String accessToken) {
		ResultDto<UserDto> user = restTemplate.getForObject(
				"http://OAUTH2-AUTHENTICATION-SERVER/user/get-by-username/{username}?access_token={accessToken}",
				ResultDto.class, username, accessToken);
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
