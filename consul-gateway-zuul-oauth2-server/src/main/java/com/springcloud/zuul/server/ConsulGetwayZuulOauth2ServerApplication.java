package com.springcloud.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ConsulGetwayZuulOauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulGetwayZuulOauth2ServerApplication.class, args);
	}

}
