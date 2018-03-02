package com.clinicalmall.kuaixiu.controller;

import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.clinicalmall.kuaixiu.service.IWorkService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetWorkRequest;
import com.clinicalmall.kuaixiu.vo.GetWorkResponse;
import com.clinicalmall.kuaixiu.vo.WorkExecuteRequest;
import com.clinicalmall.kuaixiu.vo.WorkListRequest;
import com.clinicalmall.kuaixiu.vo.WorkListResponse;
import com.clinicalmall.kuaixiu.vo.WorkSaveRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WorkApiController implements WorkApi {

	private static final Logger log = LoggerFactory
			.getLogger(WorkApiController.class);

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	@Resource
	private IWorkService workService;

	@org.springframework.beans.factory.annotation.Autowired
	public WorkApiController(ObjectMapper objectMapper,
			HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<CommonResponse> execute(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody WorkExecuteRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return workService.execute(new ApiRequestBase<WorkExecuteRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<WorkListResponse> getList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody WorkListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return workService.getList(new ApiRequestBase<WorkListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<WorkListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> save(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody WorkSaveRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return workService.save(new ApiRequestBase<WorkSaveRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<GetWorkResponse> getWork(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody GetWorkRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return workService.getWork(new ApiRequestBase<GetWorkRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<GetWorkResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
