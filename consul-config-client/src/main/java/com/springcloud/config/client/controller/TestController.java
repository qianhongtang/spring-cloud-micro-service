/**
 * 
 */
package com.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianh
 *
 */
@RefreshScope
@RestController
public class TestController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/port")
	public String port() {
		return this.port;
	}

}
