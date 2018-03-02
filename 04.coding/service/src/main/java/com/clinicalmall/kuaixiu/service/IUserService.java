package com.clinicalmall.kuaixiu.service;

import org.springframework.http.ResponseEntity;

import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetUserRequest;
import com.clinicalmall.kuaixiu.vo.GetUserResponse;
import com.clinicalmall.kuaixiu.vo.LoginRequest;
import com.clinicalmall.kuaixiu.vo.LoginResponse;
import com.clinicalmall.kuaixiu.vo.UserDeleteRequest;
import com.clinicalmall.kuaixiu.vo.UserFindPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserListRequest;
import com.clinicalmall.kuaixiu.vo.UserListResponse;
import com.clinicalmall.kuaixiu.vo.UserModifyHeadImgRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyTypeRequest;
import com.clinicalmall.kuaixiu.vo.UserRegisterRequest;

public interface IUserService {

	ResponseEntity<CommonResponse> register(
			ApiRequestBase<UserRegisterRequest> request);

	ResponseEntity<LoginResponse> login(ApiRequestBase<LoginRequest> request);

	ResponseEntity<UserListResponse> getList(
			ApiRequestBase<UserListRequest> request);

	ResponseEntity<GetUserResponse> getUser(
			ApiRequestBase<GetUserRequest> request);

	ResponseEntity<CommonResponse> modifyPwd(
			ApiRequestBase<UserModifyPwdRequest> request);

	ResponseEntity<CommonResponse> findPwd(
			ApiRequestBase<UserFindPwdRequest> request);

	ResponseEntity<CommonResponse> modify(
			ApiRequestBase<UserModifyRequest> request);

	ResponseEntity<CommonResponse> modifyHeadImg(
			ApiRequestBase<UserModifyHeadImgRequest> request);

	ResponseEntity<CommonResponse> modifyType(
			ApiRequestBase<UserModifyTypeRequest> request);

	ResponseEntity<CommonResponse> delete(
			ApiRequestBase<UserDeleteRequest> request);

	boolean checkToken(String token);

	User getUserByToken(String token);

}
