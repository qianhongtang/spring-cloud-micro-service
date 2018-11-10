/**
 * 
 */
package com.springcloud.zuul.server.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author qianh
 *
 */
public class AccessZuulFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessZuulFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();

		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

		Object accessToken = request.getParameter("access_token");
		if (accessToken == null) {
			log.warn("access token is empty");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
			return "{code: 'error', message: 'access token is empty'}";
		}
		log.info("access token ok");
		return null;
	}

}
