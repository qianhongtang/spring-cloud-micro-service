package com.springcloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ConsulServiceConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulServiceConsumerFeignApplication.class, args);
	}
}
