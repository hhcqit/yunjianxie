package com.clinicalmall.kuaixiu.service;

import org.springframework.http.ResponseEntity;

import com.clinicalmall.kuaixiu.persistent.domain.Plan;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetPlanRequest;
import com.clinicalmall.kuaixiu.vo.GetPlanResponse;
import com.clinicalmall.kuaixiu.vo.PlanDeleteRequest;
import com.clinicalmall.kuaixiu.vo.PlanListRequest;
import com.clinicalmall.kuaixiu.vo.PlanListResponse;
import com.clinicalmall.kuaixiu.vo.PlanSaveRequest;
import com.clinicalmall.kuaixiu.vo.PlanUpdateStatusRequest;

public interface IPlanService {

	ResponseEntity<CommonResponse> save(ApiRequestBase<PlanSaveRequest> request);

	ResponseEntity<CommonResponse> delete(ApiRequestBase<PlanDeleteRequest> request);

	ResponseEntity<CommonResponse> updateStatus(ApiRequestBase<PlanUpdateStatusRequest> request);

	ResponseEntity<PlanListResponse> getList(ApiRequestBase<PlanListRequest> request);

	ResponseEntity<GetPlanResponse> getPlan(ApiRequestBase<GetPlanRequest> request);

	void genPlanInstance(Plan plan);

}
