package com.clinicalmall.kuaixiu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.clinicalmall.kuaixiu.persistent.dao.AttachmentMapper;
import com.clinicalmall.kuaixiu.persistent.domain.Attachment;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.SendSmsCodeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@Controller
public class CommonApiController implements CommonApi {
	private static final Logger log = LoggerFactory.getLogger(CommonApiController.class);

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	private final HttpServletResponse response;

	@Resource
	private ICommonService commonService;
	@Resource
	private AttachmentMapper attachmentMapper;

	@org.springframework.beans.factory.annotation.Autowired
	public CommonApiController(ObjectMapper objectMapper, HttpServletRequest request, HttpServletResponse response) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.response = response;
	}
	
	@Override
	public ResponseEntity<CommonResponse> sendSmsCode(
			@ApiParam(value = "发送短信验证码", required = true) @Valid @RequestBody SendSmsCodeRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return commonService.sendSmsCode(new ApiRequestBase<SendSmsCodeRequest>(body));
		}
		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> getAttachment(
			@ApiParam(value = "附件ID", required = true) @PathVariable("attachmentId") String attachmentId) {
		Attachment attachment = attachmentMapper.selectByPrimaryKey(Long.parseLong(attachmentId));
		if (attachment == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
		FileInputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			File file = new File(uploadPath, attachment.getName());
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			int length = 0;
			byte buffer[] = new byte[1024];
			while ((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// response.setContentType("image/png");
		return null;
	}

	@Override
	public ResponseEntity<CommonResponse> uploadAttachment(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "附件文件") @Valid @RequestPart("file") MultipartFile file,
			@ApiParam(value = "文件类型<br>0、未定义  1、图片 2、语音 3、文件") @RequestPart(value = "type", required = false) Integer type) {
		return commonService.uploadAttachment(token, type, file, request);
	}
}
