package com.wisdontech.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.wisdontech.zuul.server.filter.AccessZuulFilter;

@EnableZuulProxy
@SpringCloudApplication
public class ConsulGetwayZuulOauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulGetwayZuulOauth2ServerApplication.class, args);
	}

	@Bean
	public AccessZuulFilter accessZuulFilter() {
		return new AccessZuulFilter();
	}
}
