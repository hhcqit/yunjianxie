package com.clinicalmall.kuaixiu.service;

import org.springframework.http.ResponseEntity;

import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetOrgRequest;
import com.clinicalmall.kuaixiu.vo.GetOrgResponse;
import com.clinicalmall.kuaixiu.vo.GetUserRequest;
import com.clinicalmall.kuaixiu.vo.GetUserResponse;
import com.clinicalmall.kuaixiu.vo.OrgBindListRequest;
import com.clinicalmall.kuaixiu.vo.OrgBindRequest;
import com.clinicalmall.kuaixiu.vo.OrgChangeAdminRequest;
import com.clinicalmall.kuaixiu.vo.OrgListRequest;
import com.clinicalmall.kuaixiu.vo.OrgListResponse;
import com.clinicalmall.kuaixiu.vo.OrgModifyRequest;
import com.clinicalmall.kuaixiu.vo.OrgRegisterRequest;
import com.clinicalmall.kuaixiu.vo.OrgUnbindRequest;

public interface IOrgService {
	ResponseEntity<CommonResponse> register(
			ApiRequestBase<OrgRegisterRequest> request);

	ResponseEntity<CommonResponse> modify(
			ApiRequestBase<OrgModifyRequest> request);

	ResponseEntity<CommonResponse> changeAdmin(
			ApiRequestBase<OrgChangeAdminRequest> request);

	ResponseEntity<OrgListResponse> getList(
			ApiRequestBase<OrgListRequest> request);

	ResponseEntity<GetOrgResponse> getOrg(ApiRequestBase<GetOrgRequest> request);

	ResponseEntity<CommonResponse> bind(ApiRequestBase<OrgBindRequest> request);

	ResponseEntity<CommonResponse> unbind(
			ApiRequestBase<OrgUnbindRequest> request);

	ResponseEntity<OrgListResponse> getBindList(
			ApiRequestBase<OrgBindListRequest> request);
}
