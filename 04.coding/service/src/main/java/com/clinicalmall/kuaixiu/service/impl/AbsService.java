package com.clinicalmall.kuaixiu.service.impl;

import java.util.List;

import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.Equipment;
import com.clinicalmall.kuaixiu.vo.EquipmentListResponse;
import com.clinicalmall.kuaixiu.vo.LoginResponse;
import com.clinicalmall.kuaixiu.vo.LoginUser;
import com.clinicalmall.kuaixiu.vo.Plan;
import com.clinicalmall.kuaixiu.vo.PlanListResponse;
import com.clinicalmall.kuaixiu.vo.Work;
import com.clinicalmall.kuaixiu.vo.WorkListResponse;

public abstract class AbsService {
	public CommonResponse genCommonResponseWithSuccessful() {
		return genCommonResponseWithSuccessful(null, null);
	}

	public CommonResponse genCommonResponseWithSuccessful(String msg) {
		return genCommonResponseWithSuccessful(msg, null);
	}

	public CommonResponse genCommonResponseWithSuccessful(String msg, String data) {
		return genCommonResponse(ApiResponseBase.CODE_SUCCESSFUL, msg, data);
	}

	public CommonResponse genCommonResponseWithFailed(String msg) {
		return genCommonResponseWithFailed(msg, null);
	}

	public CommonResponse genCommonResponseWithFailed(String msg, String data) {
		return genCommonResponse(ApiResponseBase.CODE_FAILED, msg, data);
	}

	public CommonResponse genCommonResponseWithInvalidToken() {
		return genCommonResponse(ApiResponseBase.CODE_INVALID_SESSION, "用户未登录！", null);
	}

	public CommonResponse genCommonResponse(int code, String msg, String data) {
		CommonResponse response = new CommonResponse();
		response.setCode(code);
		response.setMsg(msg);
		response.setData(data);
		return response;
	}

	public LoginResponse genLoginResponseWithSuccessful(String msg, LoginUser data) {
		return genLoginResponse(ApiResponseBase.CODE_SUCCESSFUL, msg, data);
	}

	public LoginResponse genLoginResponseWithFailed(String msg) {
		return genLoginResponse(ApiResponseBase.CODE_FAILED, msg, null);
	}

	public LoginResponse genLoginResponse(int code, String msg, LoginUser data) {
		LoginResponse response = new LoginResponse();
		response.setCode(code);
		response.setMsg(msg);
		response.setData(data);
		return response;
	}

	public EquipmentListResponse genEquipmentListResponseWithInvalidToken() {
		return genEquipmentListResponse(ApiResponseBase.CODE_INVALID_SESSION, "用户未登录！", 0, null);
	}

	public EquipmentListResponse genEquipmentListResponseWithFailed(String msg) {
		return genEquipmentListResponse(ApiResponseBase.CODE_FAILED, msg, 0, null);
	}

	public EquipmentListResponse genEquipmentListResponseWithSuccessful(String msg, long total, List<Equipment> data) {
		return genEquipmentListResponse(ApiResponseBase.CODE_SUCCESSFUL, msg, total, data);
	}

	public EquipmentListResponse genEquipmentListResponse(int code, String msg, long totalRow, List<Equipment> data) {
		EquipmentListResponse response = new EquipmentListResponse();
		response.setCode(code);
		response.setMsg(msg);
		response.setTotalRow(totalRow);
		response.setData(data);
		return response;
	}

	public PlanListResponse genPlanListResponseWithInvalidToken() {
		return genPlanListResponse(ApiResponseBase.CODE_INVALID_SESSION, "用户未登录！", 0, null);
	}

	public PlanListResponse genPlanListResponseWithFailed(String msg) {
		return genPlanListResponse(ApiResponseBase.CODE_FAILED, msg, 0, null);
	}

	public PlanListResponse genPlanListResponseWithSuccessful(String msg, long total, List<Plan> data) {
		return genPlanListResponse(ApiResponseBase.CODE_SUCCESSFUL, msg, total, data);
	}

	public PlanListResponse genPlanListResponse(int code, String msg, long totalRow, List<Plan> data) {
		PlanListResponse response = new PlanListResponse();
		response.setCode(code);
		response.setMsg(msg);
		response.setTotalRow(totalRow);
		response.setData(data);
		return response;
	}

	public WorkListResponse genWorkListResponseWithInvalidToken() {
		return genWorkListResponse(ApiResponseBase.CODE_INVALID_SESSION, "用户未登录！", 0, null);
	}

	public WorkListResponse genWorkListResponseWithFailed(String msg) {
		return genWorkListResponse(ApiResponseBase.CODE_FAILED, msg, 0, null);
	}

	public WorkListResponse genWorkListResponseWithSuccessful(String msg, long total, List<Work> data) {
		return genWorkListResponse(ApiResponseBase.CODE_SUCCESSFUL, msg, total, data);
	}

	public WorkListResponse genWorkListResponse(int code, String msg, long totalRow, List<Work> data) {
		WorkListResponse response = new WorkListResponse();
		response.setCode(code);
		response.setMsg(msg);
		response.setTotalRow(totalRow);
		response.setData(data);
		return response;
	}
}
