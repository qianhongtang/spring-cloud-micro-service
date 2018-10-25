/**
 * 
 */
package com.springcloud.consumer.service.fallback;

import org.springframework.stereotype.Component;

import com.springcloud.consumer.service.ConsulService;

/**
 * @author qianh
 *
 */
@Component
public class ConsulServiceFallBack implements ConsulService {

	@Override
	public String info() {
		return "获取用户信息失败，做其他业务处理";
	}

	@Override
	public String hystrix() {
		return "测试熔断接口：服务不可用！";
	}

}
