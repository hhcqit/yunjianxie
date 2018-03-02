package com.clinicalmall.kuaixiu.controller;

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

import com.clinicalmall.kuaixiu.service.IEquipmentService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.Equipment;
import com.clinicalmall.kuaixiu.vo.EquipmentBindOrgRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentDeleteRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItem;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemDeleteRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineSaveRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentUpdateStatusRequest;
import com.clinicalmall.kuaixiu.vo.GetEquipmentRequest;
import com.clinicalmall.kuaixiu.vo.GetEquipmentResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@Controller
public class EquipmentApiController implements EquipmentApi {

	private static final Logger log = LoggerFactory.getLogger(EquipmentApiController.class);

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	@Resource
	private IEquipmentService equipmentService;

	@org.springframework.beans.factory.annotation.Autowired
	public EquipmentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<CommonResponse> bindOrg(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentBindOrgRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.bindOrg(new ApiRequestBase<EquipmentBindOrgRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> delete(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentDeleteRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.delete(new ApiRequestBase<EquipmentDeleteRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<EquipmentExamineItemListResponse> getExamine(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentExamineItemListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.getExamineItemList(new ApiRequestBase<EquipmentExamineItemListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<EquipmentExamineItemListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<EquipmentExamineListResponse> getExamineList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentExamineListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.getExamineList(new ApiRequestBase<EquipmentExamineListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<EquipmentExamineListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<EquipmentListResponse> getList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.getList(new ApiRequestBase<EquipmentListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<EquipmentListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> save(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody Equipment body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.save(new ApiRequestBase<Equipment>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> saveExamine(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentExamineSaveRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.saveExamine(new ApiRequestBase<EquipmentExamineSaveRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> updateStatus(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentUpdateStatusRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.updateStatus(new ApiRequestBase<EquipmentUpdateStatusRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<GetEquipmentResponse> getEquipment(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody GetEquipmentRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.getEquipment(new ApiRequestBase<GetEquipmentRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<GetEquipmentResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> archiveExamine(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentExamineSaveRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.archiveExamine(new ApiRequestBase<EquipmentExamineSaveRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> saveExamineItem(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentExamineItem body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.saveExamineItem(new ApiRequestBase<EquipmentExamineItem>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> deleteExamineItem(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody EquipmentExamineItemDeleteRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return equipmentService.deleteExamineItem(new ApiRequestBase<EquipmentExamineItemDeleteRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
