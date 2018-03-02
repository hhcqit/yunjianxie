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

import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetUserRequest;
import com.clinicalmall.kuaixiu.vo.GetUserResponse;
import com.clinicalmall.kuaixiu.vo.LoginRequest;
import com.clinicalmall.kuaixiu.vo.LoginResponse;
import com.clinicalmall.kuaixiu.vo.UserFindPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserListRequest;
import com.clinicalmall.kuaixiu.vo.UserListResponse;
import com.clinicalmall.kuaixiu.vo.UserModifyHeadImgRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyTypeRequest;
import com.clinicalmall.kuaixiu.vo.UserRegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserApiController implements UserApi {

	private static final Logger log = LoggerFactory
			.getLogger(UserApiController.class);

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	@Resource
	private IUserService userService;

	@org.springframework.beans.factory.annotation.Autowired
	public UserApiController(ObjectMapper objectMapper,
			HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<CommonResponse> findPwd(
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody UserFindPwdRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService.findPwd(new ApiRequestBase<UserFindPwdRequest>(
					null, body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<UserListResponse> getList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody UserListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService.getList(new ApiRequestBase<UserListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<UserListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<GetUserResponse> getUser(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody GetUserRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService.getUser(new ApiRequestBase<GetUserRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<GetUserResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<LoginResponse> login(
			@ApiParam(value = "登录请求消息", required = true) @Valid @RequestBody LoginRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<LoginResponse> response = userService
					.login(new ApiRequestBase<LoginRequest>(null, body));
			if (response.getStatusCode().is2xxSuccessful()) {
				LoginResponse loginResponse = response.getBody();
				if (loginResponse.getCode() == ApiResponseBase.CODE_SUCCESSFUL)
					request.getSession().setAttribute("token",
							loginResponse.getData().getToken());
			}
			return response;
		}
		return new ResponseEntity<LoginResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> modify(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody UserModifyRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService.modify(new ApiRequestBase<UserModifyRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request
							.getSession().getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> modifyHeadImg(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody UserModifyHeadImgRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService
					.modifyHeadImg(new ApiRequestBase<UserModifyHeadImgRequest>(
							StringUtils.isNoneBlank(token) ? token
									: (String) request.getSession()
											.getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> modifyPwd(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody UserModifyPwdRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService
					.modifyPwd(new ApiRequestBase<UserModifyPwdRequest>(
							StringUtils.isNoneBlank(token) ? token
									: (String) request.getSession()
											.getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> modifyType(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody UserModifyTypeRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService
					.modifyType(new ApiRequestBase<UserModifyTypeRequest>(
							StringUtils.isNoneBlank(token) ? token
									: (String) request.getSession()
											.getAttribute("token"), body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> register(
			@ApiParam(value = "注册请求消息", required = true) @Valid @RequestBody UserRegisterRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return userService
					.register(new ApiRequestBase<UserRegisterRequest>(null,
							body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
