package com.wisdontech.wisdontech.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class WisdontechGatewayZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WisdontechGatewayZuulServerApplication.class, args);
    }
}
