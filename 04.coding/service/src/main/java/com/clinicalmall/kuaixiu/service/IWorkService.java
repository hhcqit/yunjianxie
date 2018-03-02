package com.clinicalmall.kuaixiu.service;

import org.springframework.http.ResponseEntity;

import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetWorkRequest;
import com.clinicalmall.kuaixiu.vo.GetWorkResponse;
import com.clinicalmall.kuaixiu.vo.WorkExecuteRequest;
import com.clinicalmall.kuaixiu.vo.WorkListRequest;
import com.clinicalmall.kuaixiu.vo.WorkListResponse;
import com.clinicalmall.kuaixiu.vo.WorkSaveRequest;

public interface IWorkService {

	ResponseEntity<CommonResponse> save(ApiRequestBase<WorkSaveRequest> request);

	ResponseEntity<CommonResponse> execute(
			ApiRequestBase<WorkExecuteRequest> request);

	ResponseEntity<WorkListResponse> getList(
			ApiRequestBase<WorkListRequest> request);

	ResponseEntity<GetWorkResponse> getWork(
			ApiRequestBase<GetWorkRequest> request);

}
