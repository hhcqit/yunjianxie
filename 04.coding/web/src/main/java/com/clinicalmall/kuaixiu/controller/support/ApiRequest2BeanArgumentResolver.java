package com.clinicalmall.kuaixiu.controller.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiRequest2BeanArgumentResolver implements
		HandlerMethodArgumentResolver {
	private static final Logger logger = Logger
			.getLogger(ApiRequest2BeanArgumentResolver.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(ApiRequest.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest request = webRequest
				.getNativeRequest(HttpServletRequest.class);
		// logger.info(request.getContentType());
		// content-type不是json的不处理
		// if (request.getContentType() == null
		// || request.getContentType().trim().equals("")
		// || !request.getContentType().contains(
		// "application/x-www-form-urlencoded;")) {
		// return null;
		// }
		Map<String, String[]> parameterMap = request.getParameterMap();
		// logger.info(parameterMap);

		Map<String, Object> parameters = new HashMap<String, Object>();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			if (entry.getValue() == null || entry.getValue().length == 1)
				parameters.put(entry.getKey(), entry.getValue()[0]);
			else
				parameters.put(entry.getKey(), entry.getValue());
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		return mapper.readValue(mapper.writeValueAsString(parameters),
				parameter.getParameterType());
		// 把reqeust的body读取到StringBuilder
		// BufferedReader reader = request.getReader();
		// StringBuilder sb = new StringBuilder();
		//
		// char[] buf = new char[1024];
		// int rd;
		// while ((rd = reader.read(buf)) != -1) {
		// sb.append(buf, 0, rd);
		// }
		// logger.info(sb.toString());
		// return null;
		// 利用fastjson转换为对应的类型
		// if (JSONObjectWrapper.class.isAssignableFrom(parameter
		// .getParameterType())) {
		// return new JSONObjectWrapper(JSON.parseObject(sb.toString()));
		// } else {
		// return JSON
		// .parseObject(sb.toString(), parameter.getParameterType());
		// }
	}
}