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

import com.clinicalmall.kuaixiu.service.IPlanService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetPlanRequest;
import com.clinicalmall.kuaixiu.vo.GetPlanResponse;
import com.clinicalmall.kuaixiu.vo.PlanDeleteRequest;
import com.clinicalmall.kuaixiu.vo.PlanListRequest;
import com.clinicalmall.kuaixiu.vo.PlanListResponse;
import com.clinicalmall.kuaixiu.vo.PlanSaveRequest;
import com.clinicalmall.kuaixiu.vo.PlanUpdateStatusRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PlanApiController implements PlanApi {

	private static final Logger log = LoggerFactory
			.getLogger(PlanApiController.class);

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	@Resource
	private IPlanService planService;

	@org.springframework.beans.factory.annotation.Autowired
	public PlanApiController(ObjectMapper objectMapper,
			HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<CommonResponse> delete(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody PlanDeleteRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return planService.delete(new ApiRequestBase<PlanDeleteRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<PlanListResponse> getList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody PlanListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return planService.getList(new ApiRequestBase<PlanListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<PlanListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> save(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody PlanSaveRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return planService.save(new ApiRequestBase<PlanSaveRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> updateStatus(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody PlanUpdateStatusRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return planService
					.updateStatus(new ApiRequestBase<PlanUpdateStatusRequest>(
							StringUtils.isNoneBlank(token) ? token
									: (String) request.getSession()
											.getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<GetPlanResponse> getPlan(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody GetPlanRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return planService.getPlan(new ApiRequestBase<GetPlanRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<GetPlanResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
