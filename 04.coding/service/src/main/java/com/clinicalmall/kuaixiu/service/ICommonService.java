package com.clinicalmall.kuaixiu.service;

import javax.servlet.http.HttpServletRequest;

import org.redisson.RedissonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.SendSmsCodeRequest;

public interface ICommonService {

	RedissonClient getRedissonClient();

	ResponseEntity<CommonResponse> sendSmsCode(ApiRequestBase<SendSmsCodeRequest> request);

	ResponseEntity<CommonResponse> uploadAttachment(String token, Integer type, MultipartFile multipartFile,
			HttpServletRequest httpServletRequest);

	boolean checkSmsCode(String mobile, String code);

	boolean sendSms(String mobile, String content, int type, String relateId);

	int getUserTokenExpiry(int userType);

}
