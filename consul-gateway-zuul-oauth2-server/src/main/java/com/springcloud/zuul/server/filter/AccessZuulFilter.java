/**
 * 
 */
package com.springcloud.zuul.server.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.springcloud.zuul.server.service.Oauth2Service;
import com.wisdontech.common.dto.ResultDto;
import com.wisdontech.common.dto.ResultDtoFactory;

/**
 * @author qianh
 *
 */
public class AccessZuulFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessZuulFilter.class);

	@Autowired
	Oauth2Service oauth2Service;

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

		String oauthUri = "/oauth2-authentication-server/oauth/";

		if (request.getRequestURI().startsWith(oauthUri)) {
			return null;
		}

		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

		Object accessToken = request.getParameter("access_token");

		if (accessToken == null) {
			log.warn("access token is empty");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			requestContext.setResponseBody(new Gson().toJson(ResultDtoFactory.toError("access token is empty")));
			return null;
		}

		ResultDto<?> json = oauth2Service.checkToken(accessToken.toString());

		if (!"active".equals(json.getCode())) {
			log.warn("access token is error");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			requestContext.setResponseBody(new Gson().toJson(json));
			return null;
		}

		log.info("access token ok");
		return null;
	}

}
