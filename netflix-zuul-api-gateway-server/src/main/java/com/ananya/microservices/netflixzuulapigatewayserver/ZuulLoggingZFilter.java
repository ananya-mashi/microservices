package com.ananya.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingZFilter extends ZuulFilter{
    
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest req=RequestContext.getCurrentContext().getRequest();
		logger.info("req ->{}req uri ->{}",req,req.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	
	
}
