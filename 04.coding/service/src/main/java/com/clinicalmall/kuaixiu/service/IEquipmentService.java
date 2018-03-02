package com.clinicalmall.kuaixiu.service;

import org.springframework.http.ResponseEntity;

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

public interface IEquipmentService {

	ResponseEntity<CommonResponse> save(ApiRequestBase<Equipment> request);

	ResponseEntity<CommonResponse> delete(ApiRequestBase<EquipmentDeleteRequest> request);

	ResponseEntity<CommonResponse> updateStatus(ApiRequestBase<EquipmentUpdateStatusRequest> request);

	ResponseEntity<EquipmentListResponse> getList(ApiRequestBase<EquipmentListRequest> request);

	ResponseEntity<GetEquipmentResponse> getEquipment(ApiRequestBase<GetEquipmentRequest> request);

	ResponseEntity<CommonResponse> bindOrg(ApiRequestBase<EquipmentBindOrgRequest> request);

	ResponseEntity<CommonResponse> saveExamine(ApiRequestBase<EquipmentExamineSaveRequest> request);

	ResponseEntity<CommonResponse> archiveExamine(ApiRequestBase<EquipmentExamineSaveRequest> request);

	ResponseEntity<EquipmentExamineListResponse> getExamineList(ApiRequestBase<EquipmentExamineListRequest> request);

	ResponseEntity<EquipmentExamineItemListResponse> getExamineItemList(
			ApiRequestBase<EquipmentExamineItemListRequest> request);

	ResponseEntity<CommonResponse> saveExamineItem(ApiRequestBase<EquipmentExamineItem> request);

	ResponseEntity<CommonResponse> deleteExamineItem(ApiRequestBase<EquipmentExamineItemDeleteRequest> request);

}
