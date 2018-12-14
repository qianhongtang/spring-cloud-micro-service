/**
 * 
 */
package com.springcloud.zuul.server.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
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
		return FilterConstants.PRE_TYPE;
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
			requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			requestContext.setResponseBody(new Gson().toJson("{ code: 'error', message: 'access token is empty'}"));
			return null;
		}

		log.info("access token ok");
		return null;
	}

}
