package com.clinicalmall.kuaixiu.controller.support;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.IUserService;

public class DebugInterceptor extends HandlerInterceptorAdapter {
	/** 日志实例 */
	private static final Logger logger = Logger
			.getLogger(DebugInterceptor.class);
	private boolean debug = false;
	@Resource
	private ICommonService commonService;
	@Resource
	private IUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("request.getServletPath()=" + request.getServletPath()
				+ ",handler=" + handler);

		String token = request.getHeader("token");
		if (StringUtils.isBlank(token)) {
			token = (String) request.getSession().getAttribute("token");
		}
		if (StringUtils.isNoneBlank(token) && userService.checkToken(token)) {
			return true;
		}
		// response.getWriter().print("{\"code\":1,\"msg\":\"invalid token\"}");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (debug) {
			if (handler instanceof HandlerMethod) {
				HandlerMethod method = (HandlerMethod) handler;
				ResponseBody responseBody = method
						.getMethodAnnotation(ResponseBody.class);
				if (responseBody != null) {
					MethodParameter methodParameter = method.getReturnType();
				}
			}
		}

	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
}
