package com.dashboard.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dashboard.spring.service.ClientRequestService;

public class CustomInterceptor implements HandlerInterceptor {

	Logger log=Logger.getLogger(CustomInterceptor.class);
	
	@Autowired
	private ClientRequestService clientRequestService;
	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception ex)
			throws Exception {
		log.info("Called handler method : afterCompletion");

	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mav)
			throws Exception {
		log.info("Called handler method : postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		log.info("Called before handler method : PreHandle");
		this.clientRequestService.persistClientReq(req);
	    return true;
	}

}
