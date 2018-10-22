package com.wisdontech.wisdontech.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdontech.wisdontech.eureka.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;

	@GetMapping("/hello")
	public String hello() {
		return helloService.hello();
	}
}
