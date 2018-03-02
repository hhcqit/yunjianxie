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

import com.clinicalmall.kuaixiu.service.IOrgService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetOrgRequest;
import com.clinicalmall.kuaixiu.vo.GetOrgResponse;
import com.clinicalmall.kuaixiu.vo.OrgBindListRequest;
import com.clinicalmall.kuaixiu.vo.OrgBindRequest;
import com.clinicalmall.kuaixiu.vo.OrgChangeAdminRequest;
import com.clinicalmall.kuaixiu.vo.OrgListRequest;
import com.clinicalmall.kuaixiu.vo.OrgListResponse;
import com.clinicalmall.kuaixiu.vo.OrgModifyRequest;
import com.clinicalmall.kuaixiu.vo.OrgRegisterRequest;
import com.clinicalmall.kuaixiu.vo.OrgUnbindRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class OrgApiController implements OrgApi {

	private static final Logger log = LoggerFactory
			.getLogger(OrgApiController.class);

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	@Resource
	private IOrgService orgService;

	@org.springframework.beans.factory.annotation.Autowired
	public OrgApiController(ObjectMapper objectMapper,
			HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<CommonResponse> bind(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody OrgBindRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService.bind(new ApiRequestBase<OrgBindRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> changeAdmin(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody OrgChangeAdminRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService
					.changeAdmin(new ApiRequestBase<OrgChangeAdminRequest>(
							StringUtils.isNoneBlank(token) ? token
									: (String) request.getSession()
											.getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<OrgListResponse> getBindList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody OrgBindListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService
					.getBindList(new ApiRequestBase<OrgBindListRequest>(
							StringUtils.isNoneBlank(token) ? token
									: (String) request.getSession()
											.getAttribute("token"), body));
		}
		return new ResponseEntity<OrgListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<OrgListResponse> getList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody OrgListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService.getList(new ApiRequestBase<OrgListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<OrgListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> modify(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody OrgModifyRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService.modify(new ApiRequestBase<OrgModifyRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> register(
			@ApiParam(value = "注册请求消息", required = true) @Valid @RequestBody OrgRegisterRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService.register(new ApiRequestBase<OrgRegisterRequest>(
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> unbind(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody OrgUnbindRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService.unbind(new ApiRequestBase<OrgUnbindRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<GetOrgResponse> getOrg(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody GetOrgRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return orgService.getOrg(new ApiRequestBase<GetOrgRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<GetOrgResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
